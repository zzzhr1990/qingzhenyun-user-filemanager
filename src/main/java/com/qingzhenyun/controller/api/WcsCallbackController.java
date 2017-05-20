package com.qingzhenyun.controller.api;

import com.qingzhenyun.service.WcsCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Wcs
 * Created by guna on 2017/5/12.
 */
@RestController
@RequestMapping("/api/callback/ws")
public class WcsCallbackController {
    private WcsCallbackService wcsCallbackService;

    @RequestMapping("/post")
    public HashMap<String, String> upload(HttpServletRequest httpServletRequest, String callbackBody) {
        return wcsCallbackService.onSimpleCallback(callbackBody);
    }

    @Autowired
    public void setWcsCallbackService(WcsCallbackService wcsCallbackService) {
        this.wcsCallbackService = wcsCallbackService;
    }
}
