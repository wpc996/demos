package com.wpc.testservlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangpeican
 * @date 2023/2/3 1:09
 */
@Controller
@RequestMapping("/")
public class Controller2 {
    @RequestMapping("/servlet2")
    @ResponseBody
    public String servlet1() {
        return "message form servlet2";
    }
}
