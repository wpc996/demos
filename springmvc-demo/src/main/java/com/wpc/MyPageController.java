package com.wpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangwei
 * @version v1.0.0
 * @description 我的主页
 * @date 2010-01-10
 */
@RestController
@RequestMapping("/api/{version}/mypage")
public class MyPageController {
    /**
     * showdoc
     *
     * @param token 必选 string 手机号码
     * @param time  必选 int 请求时间戳
     * @return {"status":"200","message":"请求成功","data":[{"image":"http://192.168.4.170:8081/1545188000331-762166088940527181.png","orbit_id":"8","entry_time":1547006424,"company_name":"苏州富通精密机械有限公司","resignation_time":1547006424,"work_status":"52110"},{"image":"http://192.168.4.170:8081/1545188000331-762166088940527181.png","orbit_id":"9","entry_time":1547006424,"company_name":"航天信息","resignation_time":1547006424,"work_status":"52100"}],"page":null,"ext":null}
     * @catalog v1.0.1/我的资料
     * @title 我的资料-获取我的职业轨迹
     * @description 根据token获取我的职业轨迹
     * @method get
     * @url /api/v1.0.1/mypage/findEmployeeHistory
     * @return_param data Object 职业轨迹数据
     * @return_param status string 状态
     * @remark 这里是备注信息
     * @number 99
     */
    @RequestMapping(value = "findEmployeeHistory", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String findEmployeeHistory(HttpServletRequest request, String token, String time) {
        Map params = new HashMap<>();
        System.out.println("user_id");
        return "test";
    }
}