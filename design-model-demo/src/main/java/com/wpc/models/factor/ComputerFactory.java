package com.wpc.models.factor;

/**
 * @author wangpeican
 * @since 2022/5/14 11:56
 */
public class ComputerFactory {

    public Computer create(String type){
        if (type == null || type.length() == 0){
            return null;
        }
        if ("Huawei".equalsIgnoreCase(type)) {
            return new HuaweiComputer();
        } else if ("Xiaomi".equalsIgnoreCase(type)) {
            return new XiaomiComputer();
        }
        return null;
    }
}
