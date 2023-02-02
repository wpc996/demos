package com.wpc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author wangpeican
 * @date 2023/1/3 23:11
 */
@Controller
@RequestMapping("/")
public class HttpServletResponseTest {

    @RequestMapping(value = "/testHttpServletResponse/test1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void testHttpServletResponse(@RequestBody Map<String, String> parameter, HttpServletResponse response) throws IOException {
        System.out.println(parameter.get("parameter1"));
        response.setStatus(200);
        response.getOutputStream().print("testHttpServletResponse");
    }

    @RequestMapping(value = "/testHttpServletResponseDownLoad/test1", method = RequestMethod.POST)
    @ResponseBody
    public void testHttpServletResponseDownLoad(HttpServletResponse resp) throws IOException {
        //        1.获取下载的文件路径；
        String realPath = "D:\\code\\java-code\\demos\\springmvc-demo\\src\\main\\resources\\map.jpg";
        System.out.println("下载文件的路径：" + realPath);
        //        2.获取下载的文件名；
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //        3.设置让浏览器能够识别我们需要的内容，同时指定下载此文件时文件的下载名；
        //        中文名用URLEncoder.encode编码，否则可能乱码
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        //        4.获取下载文件的输入流；
        FileInputStream in = new FileInputStream(realPath);
        //        5.创建缓冲区；
        int len = 0;
        byte[] buffer = new byte[1024];
        //        6.获取OutputStream对象；
        ServletOutputStream out = resp.getOutputStream();
        //        7.将FileOutputStream流写入到buffer缓冲区,使用OutputStream将缓冲区的数据输出到客户端。
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }
}
