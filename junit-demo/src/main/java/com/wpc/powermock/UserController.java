package com.wpc.powermock;

/**
 * @author wangpeican
 * @date 2022/9/20 23:02
 */
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public User saveUser(User user) {
        User save = service.save(user);
        return save;
    }

    public String returnName(){
        return getStaticName("ljw1");
    }

    public static String getStaticName(String name) {
        return "A_" + name;
    }
    public  String getPrivateName(String name) {

        if (publicCheck()){
            return "public 被mock 了";
        }
        if (check(name)){
            return "private 被mock 了";
        }
        return "A_" + name;
    }

    public boolean publicCheck() {
        return false;
    }

    private boolean check(String name) {
        return false;
    }

    private String say(String content) {
        return "ljw say " + content;
    }
}
