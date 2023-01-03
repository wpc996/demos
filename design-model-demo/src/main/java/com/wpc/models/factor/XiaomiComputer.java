package com.wpc.models.factor;

/**
 * @author wangpeican
 * @date 2022/5/14 11:55
 */
public class XiaomiComputer implements Computer {
    public void powerOn() {
        System.err.println("Xiaomi Computer power on");
    }

    public void powerOff() {
        System.err.println("Xiaomi Computer power off");
    }
}
