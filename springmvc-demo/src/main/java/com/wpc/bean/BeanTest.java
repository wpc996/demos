package com.wpc.bean;

import com.wpc.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wangpeican
 * @date 2023/1/11 20:25
 */
@RequestMapping("/testbean")
public class BeanTest {

    Bean4 bean4;

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    @ResponseBody
    public String test1() {
        System.out.println(bean4.getBean1Name());
        return "testPointTest";
    }

    public void setBean4(Bean4 bean4) {
        this.bean4 = bean4;
    }
}
