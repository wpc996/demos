package com.wpc.iml;

import org.springframework.stereotype.Controller;

/**
 * @author wangpeican
 * @date 2023/1/4 22:16
 */
//@Controller
public class InterfaceTest implements com.wpc.InterfaceTest {
    @Override
    public String test1() {
        return "test interface";
    }
}
