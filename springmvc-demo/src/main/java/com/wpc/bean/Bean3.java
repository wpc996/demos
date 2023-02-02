package com.wpc.bean;

import javax.annotation.Resource;

/**
 * @author wangpeican
 * @date 2023/1/11 22:37
 */
public class Bean3 {

    Bean2 bean2;

    public String getBean1Name() {
        return bean2.getBean1().getName();
    }

    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }
}
