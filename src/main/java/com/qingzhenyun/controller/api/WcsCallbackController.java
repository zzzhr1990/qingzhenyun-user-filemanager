package com.qingzhenyun.controller.api;

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
        HashMap<String, String> res = new HashMap<>();
        res.put("data", callbackBody);
        res.put("method", httpServletRequest.getMethod());
        res.put("uri", httpServletRequest.getRequestURL().toString());
        return res;
    }

    private String process(InputStream in, Charset charset) {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int len = 0;
        try {
            while ((len = in.read(buf)) != -1) {
                sb.append(new String(buf, 0, len, charset));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
