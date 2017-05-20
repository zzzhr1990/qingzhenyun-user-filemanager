package com.qingzhenyun.controller.api;

import com.qingzhenyun.config.wcs.WcsApi;
import com.qingzhenyun.exception.ApiException;
import com.qingzhenyun.jooq.common.generated.tables.pojos.User;
import com.qingzhenyun.wcs.entity.PutPolicy;
import com.qingzhenyun.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * UC yo
 * Created by guna on 2017/5/12.
 */

@RestController
@RequestMapping("/api/upload")
public class UploadController {
    private static final String BUCKET = "other-storage";
    private static final String DEFAULT_CALLBACK_URL = "http://tencent2.qiecdn.com:8090/api/callback/ws/post";
    private static final String DEFAULT_RETURN_BODY = "{\"key\": $(key),\"mimeType\": $(mimeType),\"size\": $(fsize),\"fname\": $(fname), \"hash\": $(etag), \"avinfo\": $(avinfo), \"imageInfo\": $(imageInfo)}";

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public HashMap<String, String> getToken(Integer userId) {
        if (userId == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "USER_ID_MISSING");
        }
        HashMap<String, String> res = new HashMap<>();
        //User user = UserUtil.getUserInSession();
        PutPolicy putPolicy = new PutPolicy(); // 上传策略
        putPolicy.setOverwrite(1);
        putPolicy.setCallbackUrl(DEFAULT_CALLBACK_URL);
        putPolicy.setCallbackBody("size=$(fsize)&hash=$(hash)&key=$(key)&mimeType=$(mimeType)&ip=$(ip)&avinfo=$(avinfo)&bucket=$(bucket)&url=@qzyurlstart$(url)@qzyurlend&userId="
                + userId.toString() + "&fileName=@qzyfilestart$(fname)@qzyfileend");
        putPolicy.setDeadline(Long.toString(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        putPolicy.setSaveKey("user-upload/$(hash)");
        putPolicy.setScope(BUCKET);
        String uploadToken = wcsApi.getUploadToken(putPolicy);
        res.put("token", uploadToken);
        res.put("uploadUrl", wcsApi.getUploadUrl());
        //Send MQ..
        return res;
    }

    @Autowired
    public void setWcsApi(WcsApi wcsApi) {
        this.wcsApi = wcsApi;
    }

    private WcsApi wcsApi;
}
