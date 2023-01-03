package com.wpc.sftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.sshd.common.channel.Channel;
import org.apache.sshd.scp.server.ScpCommandFactory;
import org.apache.sshd.sftp.server.SftpSubsystemFactory;
import org.junit.After;
import org.junit.Before;
import com.jcraft.jsch.*;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Properties;
import java.util.Vector;

/**
 * @author wangpeican
 * @date 2022/9/17 9:10
 */
@Slf4j
public class SftpTest {


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
        Channel channel = null;
        ChannelSftp sftp = null;
        try {
            JSch jSch = new JSch();
            //以test身份登录，默认在2294端口
            Session session = jSch.getSession("test", "localhost", 2294);
            session.setPassword("password");
            Properties config = new Properties();
            //设置不用检查HostKey
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            //使用sftp操作
            channel = (Channel) session.openChannel("sftp");
            ((com.jcraft.jsch.Channel) channel).connect();
            sftp = (ChannelSftp) channel;
            //操作-----------------------------------------------
            sftp.cd("/");
            InputStream is = new InputStream() {
                @Override
                public int read() throws IOException {
                    return -1;
                }
            };
            sftp.put(is, "emptyFile.txt");
            Vector<ChannelSftp.LsEntry> files = sftp.ls("/");
            files.forEach(r -> System.out.println(r.getFilename()));
            //操作-----------------------------------------------
            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("错误{}", e.getMessage());
        } finally {
            assert sftp != null;
            sftp.disconnect();
            ((ChannelSftp) channel).disconnect();
        }
    }
}
