package com.wpc.models.factor;

/**
 * @author wangpeican
 * @date 2022/5/14 15:28
 */
public class Client {

    public static void main(String[] args) {
        Computer huawei = new ComputerFactory().create("Huawei");
        huawei.powerOn();
        huawei.powerOff();
        Computer xiaomi = new ComputerFactory().create("Xiaomi");
        xiaomi.powerOn();
        xiaomi.powerOff();
    }
}