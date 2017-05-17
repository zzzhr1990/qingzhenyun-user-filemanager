package com.qingzhenyun.service;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.qingzhenyun.constans.MqConst;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Post...
 * Created by guna on 2017/5/13.
 */
@Service
public class OfflineTaskService {
    @Async
    public void dispatchTorrentAdded(String bucket, String key, String url, String hash, Integer userId) {
        HashMap<String, String> h = new HashMap<>();
        h.put("bucket", bucket);
        h.put("key", key);
        h.put("url", url);
        h.put("hash", hash);
        h.put("type", "torrent");
        h.put("userId", userId.toString());
        rabbitMessagingTemplate.convertAndSend(MqConst.OFFLINE_EXCHANGE, MqConst.OFFLINE_ADD_ROUTING_KEY, h);
    }

    @Async
    public void dispatchMagnetAdded(String url, Integer userId) {
        HashMap<String, String> h = new HashMap<>();
        h.put("url", url);
        h.put("hash", "mag-" + Hashing.md5().hashString(url, Charsets.UTF_8).toString());
        h.put("type", "magnet");
        h.put("userId", userId.toString());
        rabbitMessagingTemplate.convertAndSend(MqConst.OFFLINE_EXCHANGE, MqConst.OFFLINE_ADD_ROUTING_KEY, h);
    }

    @Autowired
    public void setRabbitMessagingTemplate(RabbitMessagingTemplate rabbitMessagingTemplate) {
        this.rabbitMessagingTemplate = rabbitMessagingTemplate;
    }

    private RabbitMessagingTemplate rabbitMessagingTemplate;
}
