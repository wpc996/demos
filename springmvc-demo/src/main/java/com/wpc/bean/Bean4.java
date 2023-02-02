package com.wpc.bean;

import javax.annotation.Resource;

/**
 * @author wangpeican
 * @date 2023/1/11 22:56
 */
public class Bean4 {
    Bean3 bean3;

    public void setBean3(Bean3 bean3) {
        this.bean3 = bean3;
    }

    public String getBean1Name() {
        return bean3.getBean1Name();
    }
}
