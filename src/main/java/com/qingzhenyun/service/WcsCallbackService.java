package com.qingzhenyun.service;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;

/**
 * S
 * Created by guna on 2017/5/13.
 */
@Service
public class WcsCallbackService {
    public HashMap<String, String> onSimpleCallback(String returnBody) {
        HashMap<String, String> result = new HashMap<>();
        String[] keyPair = returnBody.split("&");
        for (String str : keyPair) {
            int s = str.indexOf('=');
            if (s > -1) {
                String key = new String(Base64.getUrlDecoder()
                        .decode(str.substring(0, s)), Charsets.UTF_8);
                String value = new String(Base64.getUrlDecoder()
                        .decode(str.substring(s + 1)), Charsets.UTF_8);
                result.put(key, value);
            }
        }
        return result;
    }
}
