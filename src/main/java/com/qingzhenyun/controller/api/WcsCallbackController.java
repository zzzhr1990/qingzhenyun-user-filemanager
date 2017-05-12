package com.qingzhenyun.controller.api;

import com.qingzhenyun.service.WcsCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.UUID;

/**
 * Wcs
 * Created by guna on 2017/5/12.
 */
@RestController
@RequestMapping("/api/callback/ws")
public class WcsCallbackController {
    @RequestMapping("/post")
    public HashMap<String, String> upload(HttpServletRequest httpServletRequest, String callbackBody) {
        return wcsCallbackService.onSimpleCallback(callbackBody);
    }

    @Autowired
    public void setWcsCallbackService(WcsCallbackService wcsCallbackService) {
        this.wcsCallbackService = wcsCallbackService;
    }

    private WcsCallbackService wcsCallbackService;
}
