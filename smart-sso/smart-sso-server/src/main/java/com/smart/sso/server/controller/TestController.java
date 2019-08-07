package com.smart.sso.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @FileName: TestController
 * @Author: longer 199429
 * @Date: 2019-08-06 16:35
 * @Description: ${DESCRIPTION}
 */
@RequestMapping
@Controller
public class TestController {
    @RequestMapping("/test")
    public Object test () {
        return "test" ;
    }
}
