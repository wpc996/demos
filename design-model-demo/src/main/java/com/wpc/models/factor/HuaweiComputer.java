package com.wpc.models.factor;

/**
 * @author wangpeican
 * @date 2022/5/14 11:55
 */
public class HuaweiComputer implements Computer {
    public void powerOn() {
        System.err.println("Huawei Computer power on");
    }

    public void powerOff() {
        System.err.println("Huawei Computer power off");
    }
}
