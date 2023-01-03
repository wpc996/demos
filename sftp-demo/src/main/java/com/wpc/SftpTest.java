package com.wpc;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.config.hosts.KnownHostDigest;
import org.apache.sshd.client.keyverifier.KnownHostsServerKeyVerifier;
import org.apache.sshd.client.keyverifier.RejectAllServerKeyVerifier;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.cipher.BuiltinCiphers;
import org.apache.sshd.common.cipher.Cipher;
import org.apache.sshd.common.mac.BuiltinMacs;
import org.apache.sshd.common.mac.Mac;
import org.apache.sshd.sftp.client.SftpClient;
import org.apache.sshd.sftp.client.SftpClientFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wangpeican
 * @date 2022/9/18 12:07
 */
public class SftpTest {
    public static void main(String[] args) {
        try (SshClient client = SshClient.setUpDefaultClient()) {
            client.start();
            reconfigureSshCipher(client);
            Path path = Paths.get("D:\\code\\java-code\\demos\\sftp-demo\\src\\main\\resources\\know_host");
            KnownHostsServerKeyVerifier tmp = new KnownHostsServerKeyVerifier(RejectAllServerKeyVerifier.INSTANCE, path);
            client.setServerKeyVerifier(tmp);
            try (ClientSession session = client.connect("root", "192.168.74.111", 22).verify().getSession()) {
                session.addPasswordIdentity("Wpc4738..");
                session.auth().verify();
                SftpClient sftpClient = SftpClientFactory.instance().createSftpFileSystem(session).getClient();
//                OutputStream outputStream = sftpClient.write("/opt/a/bc/test/wpc.txt", SftpClient.OpenMode.Write, SftpClient.OpenMode.Append);
                OutputStream outputStream = sftpClient.write("/opt/a/bc/test/wpc.txt", SftpClient.OpenMode.Write, SftpClient.OpenMode.Create);
                outputStream.write("123456".getBytes(StandardCharsets.UTF_8));
                outputStream.close();
                InputStream inputStream = sftpClient.read("/opt/a/bc/test/wpc.txt");
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
        BuiltinMacs.ParseResult macsResult = BuiltinMacs.parseMacsList("hmac-sha1,hmac-sha1-96,hmac-sha2-256,hmac-sha2-512,hmac-md5,hmac-md5-96,hmac-ripemd160,hmac-ripemd160@openssh.com,umac-64@openssh.com,umac-128@openssh.com,hmac-sha1-etm@openssh.com,hmac-sha1-96-etm@openssh.com,hmac-sha2-256-etm@openssh.com,hmac-sha2-512-etm@openssh.com,hmac-md5-etm@openssh.com,hmac-md5-96-etm@openssh.com,hmac-ripemd160-etm@openssh.com,umac-64-etm@openssh.com,umac-128-etm@openssh.com");
        Collection<? extends NamedFactory<Mac>> macsAvailable = macsResult.getParsedFactories();
        List<NamedFactory<Mac>> macsFactor = new ArrayList<>(macsAvailable);
        client.setMacFactories(macsFactor);
    }
}
