package com.qingzhenyun.wcs.util;

import com.qingzhenyun.wcs.entity.PutPolicy;

/**
 * Token Utils
 * Created by guna on 2017/5/12.
 */
public class TokenUtil {
    /**
     * 获取上传的token
     *
     * @param putPolicy
     * @return d
     */
    public static String getUploadToken(PutPolicy putPolicy, String ak, String sk) {
        JsonMapper jsonMapper = JsonMapper.nonEmptyMapper();
        String putPolicyStr = jsonMapper.toJson(putPolicy);
        String encodePutPolicy = EncodeUtils.urlsafeEncode(putPolicyStr);
        String singSk = EncryptUtil.sha1Hex(encodePutPolicy.getBytes(), sk);//签名
        String skValue = EncodeUtils.urlsafeEncode(singSk);//Base64编码
        return ak + ":" + skValue + ":" + encodePutPolicy;
    }


    /**
     * 获取删除的token
     *
     * @param bucketName 空间名称
     * @param fileName   文件名称
     * @return s
     */
    public static String getDeleteToken(String bucketName, String fileName, String ak, String sk) {
        String encodedEntryURI = EncodeUtils.urlsafeEncodeString((bucketName + ":" + fileName).getBytes());
        String encodeDeletePath = "/delete/" + encodedEntryURI + "\n";
        String signSk = EncryptUtil.sha1Hex(encodeDeletePath.getBytes(), sk);//签名
        String encodedSign = EncodeUtils.urlsafeEncode(signSk);//Base64编码
        return ak + ":" + encodedSign;
    }

    /**
     * 获取前缀模糊删除的token
     *
     * @param bucketName 空间名称
     * @param fileName   文件名称
     * @return s
     */
    public static String getDeletePrefixToken(String bucketName, String fileName, String ak, String sk) {
        String encodedEntryURI = EncodeUtils.urlsafeEncodeString((bucketName + ":" + fileName).getBytes());
        String encodeDeletePath = "/deletePrefix/" + encodedEntryURI + "\n";
        String signSk = EncryptUtil.sha1Hex(encodeDeletePath.getBytes(), sk);//签名
        String encodedSign = EncodeUtils.urlsafeEncode(signSk);//Base64编码
        return ak + ":" + encodedSign;
    }

    /**
     * 获取文件信息的token
     *
     * @param bucketName 空间名称
     * @param fileName   文件名称
     * @return s
     */
    public static String getStatToken(String bucketName, String fileName, String ak, String sk) {
        String encodedEntryURI = EncodeUtils.urlsafeEncodeString((bucketName + ":" + fileName).getBytes());
        String encodeDeletePath = "/stat/" + encodedEntryURI + "\n";
        String signSk = EncryptUtil.sha1Hex(encodeDeletePath.getBytes(), sk);//签名
        String encodedSign = EncodeUtils.urlsafeEncode(signSk);//Base64编码
        return ak + ":" + encodedSign;
    }

    public static String getFileListToken(String listUrl, String ak, String sk) {
        listUrl += "\n";
        String encodeDownloadUrl = EncryptUtil.sha1Hex(listUrl.getBytes(), sk);//签名
        String skValues = EncodeUtils.urlsafeEncode(encodeDownloadUrl);//Base64编码
        return ak + ":" + skValues;
    }
}
