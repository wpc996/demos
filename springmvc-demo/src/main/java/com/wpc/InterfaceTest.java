package com.wpc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author wangpeican
 * @date 2023/1/4 22:02
 */
@Controller
@RequestMapping("/")
public interface InterfaceTest {
    @RequestMapping(method = RequestMethod.POST, value = "/interfaceTest/test1")
    @ResponseBody
    String test1();
}
