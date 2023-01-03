//package com.wpc.service;
//
//import org.apache.sshd.scp.server.ScpCommandFactory;
//import org.apache.sshd.server.SshServer;
//import org.apache.sshd.server.auth.password.PasswordAuthenticator;
//import org.apache.sshd.server.command.Command;
//import org.apache.sshd.server.command.CommandFactory;
//import org.apache.sshd.server.config.keys.DefaultAuthorizedKeysAuthenticator;
//import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
//import org.apache.sshd.server.session.ServerSession;
//import org.apache.sshd.server.shell.ProcessShellFactory;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//
///**
// * @author wangpeican
// * @date 2022/9/19 0:03
// */
//public class Service {
//    public void serverTest() throws IOException, InterruptedException {
//        SshServer sshd = SshServer.setUpDefaultServer();
//        sshd.setPort(22);
//
//        //*give host key generator a path, when sshd server restart, the same key will be load and used to authenticate the server
//        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(Paths.get("hostkey.ser")));
//
//        sshd.setPasswordAuthenticator(new PasswordAuthenticator() {
//            @Override
//            public boolean authenticate(String username, String password, ServerSession session) {
//                System.out.println("authen:  user=" + username + "  password=" + password);
//                if ("bellring".equals(username) && "123456".equals(password)) return true;
//                return false;
//            }
//        });
//
//        //use file ~/.ssh/authorized_keys
//        sshd.setPublickeyAuthenticator(new DefaultAuthorizedKeysAuthenticator(false));
//
//        //* CommandFactory can be userd in addition to the ShellFactory,
//        //*  it can also be used instead of the ShellFactory.
//        //*  The CommandFactory is used when direct commands are sent to the SSH server,
//        //*  as this is the case when running ssh localhost shutdown or scp xxx
//        ScpCommandFactory scpCmdFactory = new ScpCommandFactory();
//        scpCmdFactory.setDelegateCommandFactory(new CommandFactory() {
//            public Command createCommand(String command) {
//                System.out.println("command = \"" + command + "\"");
//                return new ProcessShellFactory(("cmd /c " + command).split(" ")).create();
//            }
//        });
//        sshd.setCommandFactory(scpCmdFactory);
//
//        sshd.start();
//    }
//}
