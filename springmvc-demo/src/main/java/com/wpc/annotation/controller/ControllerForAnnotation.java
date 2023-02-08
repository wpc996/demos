package com.wpc.annotation.controller;

import com.wpc.annotation.MyAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangpeican
 * @date 2023/2/3 1:09
 */
@Controller
@RequestMapping("/")
public class ControllerForAnnotation {
    @RequestMapping("/Annotation")
    @ResponseBody
    @MyAnnotation
    public String servlet1() {
        return "message form annotation test";
    }
}
