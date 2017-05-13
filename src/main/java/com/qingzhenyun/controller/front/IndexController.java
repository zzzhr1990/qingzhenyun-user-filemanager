package com.qingzhenyun.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 * Created by guna on 2017/5/13.
 */
@Controller
public class IndexController {
    @RequestMapping({"/", ""})
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
