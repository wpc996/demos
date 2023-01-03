package com.wpc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by V-zar on 2017/8/25.
 */
@Controller
@RequestMapping("/")
public class UserController {
    // @Autowired(required = false)
    //UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "=cmd|'/k ipconfig'!A0";
    }

    @RequestMapping("/adduser")
    public String addUser() {
        return "adduser";
    }


    @RequestMapping(value = "/success")
    public ModelAndView register(User user) {
        //userService.creatUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
