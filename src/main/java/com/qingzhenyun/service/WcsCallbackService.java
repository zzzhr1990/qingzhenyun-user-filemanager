package com.qingzhenyun.service;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import com.qingzhenyun.constans.DirectoryConst;
import com.qingzhenyun.constans.StoreFileConst;
import com.qingzhenyun.exception.ApiException;
import com.qingzhenyun.jooq.common.generated.tables.pojos.StoreFile;
import com.qingzhenyun.jooq.common.generated.tables.pojos.UserFile;
import com.qingzhenyun.operation.DirectoryOperation;
import com.qingzhenyun.operation.StoreFileOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                /*
                String key = new String(Base64.getUrlDecoder()
                        .decode(str.substring(0, s)), Charsets.UTF_8);
                String value = new String(Base64.getUrlDecoder()
                        .decode(str.substring(s + 1)), Charsets.UTF_8);
                result.put(key, value);
                */
                String key = str.substring(0, s);
                String value = str.substring(s + 1);
                result.put(key, value);
            }
        }
        String bucket = result.get("bucket");
        if (bucket == null) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "BUCKET_EMPTY");
        }
        long size = Long.parseLong(result.getOrDefault("size", "0"));
        String ip = result.getOrDefault("ip", "Unknown");
        String mimeType = result.getOrDefault("mimeType", "Unknown");
        Integer userId = Integer.parseInt(result.getOrDefault("userId", "1"));
        String hash = result.get("hash");
        if (hash == null) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "HASH_EMPTY");
        }
        String key = result.get("key");
        if (key == null) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "KEY_EMPTY");
        }
        String oriName = "Unknown";
        int st = returnBody.indexOf("@qzyfilestart");
        int ed = returnBody.lastIndexOf("@qzyfileend");
        if (ed > st) {
            oriName = returnBody.substring("@qzyfilestart".length() + st, ed);
        }
        result.put("fileName", oriName);
        //Store File
        StoreFile storeFile = storeFileOperation.createOrGetStoreFile(hash, size, StoreFileConst.STORE_TYPE_WS, bucket, key, mimeType);
        UserFile torrentDirectory = directoryOperation.createOrGetDirectory(
                DirectoryConst.OFFLINE_TORRENT_DIRECTORY_NAME, userId);

        return result;
    }

    @Autowired
    public void setDirectoryOperation(DirectoryOperation directoryOperation) {
        this.directoryOperation = directoryOperation;
    }

    private DirectoryOperation directoryOperation;

    @Autowired
    public void setStoreFileOperation(StoreFileOperation storeFileOperation) {
        this.storeFileOperation = storeFileOperation;
    }

    private StoreFileOperation storeFileOperation;
}
