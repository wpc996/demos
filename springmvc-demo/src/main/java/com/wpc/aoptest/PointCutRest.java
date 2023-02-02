package com.wpc.aoptest;

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
@Controller
@RequestMapping("/testpointtest")
public class PointCutRest {

    @Resource(name = "bookDao")
    BookDao bookDao1;

    @Autowired
    BookDao bookDao2;

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    @ResponseBody
    public String test1() {
        bookDao1.update();
        bookDao1.save();
        bookDao2.update();
        bookDao2.save();
        return "testPointTest";
    }
}
