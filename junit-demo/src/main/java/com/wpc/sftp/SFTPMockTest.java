package com.wpc.sftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.cipher.BuiltinCiphers;
import org.apache.sshd.common.cipher.Cipher;
import org.apache.sshd.scp.server.ScpCommandFactory;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.sftp.client.SftpClient;
import org.apache.sshd.sftp.client.SftpClientFactory;
import org.apache.sshd.sftp.server.SftpSubsystemFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author wangpeican
 * @date 2022/9/19 0:07
 */
@Slf4j
public class SFTPMockTest {

    private SshServer sshd;

    @Before
    public void beforeTestSetup() throws Exception {
        sshd = SshServer.setUpDefaultServer();
        sshd.setPort(2294);
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider());
        sshd.setSubsystemFactories(Collections.singletonList(new SftpSubsystemFactory()));
        sshd.setPasswordAuthenticator((username, password, session) ->
                username.equals("test") && password.equals("password"));
        sshd.setCommandFactory(new ScpCommandFactory());
        sshd.start();
        log.info("SFTP server started");
    }

    @After
    public void teardown() throws Exception {
        sshd.stop();
    }

    @Test
    public void test() {
        try (SshClient client = SshClient.setUpDefaultClient()) {
            client.start();
            try (ClientSession session = client.connect("test", "localhost", 2294).verify().getSession()) {
                session.addPasswordIdentity("password");
                session.auth().verify();
                SftpClient sftpClient = SftpClientFactory.instance().createSftpFileSystem(session).getClient();
                OutputStream outputStream = sftpClient.write("wpc.txt", SftpClient.OpenMode.Write, SftpClient.OpenMode.Create);
                outputStream.write("123456".getBytes(StandardCharsets.UTF_8));
                outputStream.close();
                InputStream inputStream = sftpClient.read("wpc.txt");
                byte arr[] = new byte[3];
                int len;
                StringBuilder stringBuilder = new StringBuilder();
                while ((len = inputStream.read(arr)) != -1) {
                    stringBuilder.append(new String(arr, 0, len));
                }
                System.out.println(stringBuilder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reconfigureSshCipher(SshClient client) {
        BuiltinCiphers.ParseResult ciphersResult = BuiltinCiphers.parseCiphersList("3des-cbc,blowfish-cbc,cast128-cbc,arcfour,arcfour128,arcfour256,aes128-cbc,aes192-cbc,aes256-cbc,rijndael-cbc@lysator.liu.se,aes128-ctr,aes192-ctr,aes256-ctr,aes128-gcm@openssh.com,aes256-gcm@openssh.com,chacha20-poly1305@openssh.com");
        Collection<? extends NamedFactory<Cipher>> cipherAvailable = ciphersResult.getParsedFactories();
        List<NamedFactory<Cipher>> cipherFactor = new ArrayList<>(cipherAvailable);
        client.setCipherFactories(cipherFactor);
    }
}


