package com.qingzhenyun.listener;

import com.fasterxml.jackson.databind.JsonNode;
import com.qingzhenyun.constans.MqConst;
import com.qingzhenyun.operation.StoreFileOperation;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serv
 * Created by guna on 2017/5/28.
 */
@Service
public class TaskRabbitListener {
    @RabbitListener(bindings = @QueueBinding(value = @Queue("task-checking-queue"),
            key = MqConst.OFFLINE_UPLOAD_CHECK_ROUTING_KEY,
            exchange = @Exchange(value = MqConst.OFFLINE_EXCHANGE, type = "direct", durable = "true", autoDelete = "false")))
    public void onOfflineTaskAdded(JsonNode info) {
        //Checking Files..
        info.get("downloaded").forEach((downloaded) -> {
            //
            String fileHash = downloaded.get("file_hash").asText();
            String fileKey = downloaded.get("file_key").asText();
            String fileBucket = downloaded.get("file_bucket").asText();
            int storeType = 0;
            JsonNode storeTypeNode = downloaded.get("store_type");
            if (storeTypeNode != null) {
                storeType = storeTypeNode.asInt();
            }
            //int status = 0;
            long fileSize = downloaded.get("file_size").asLong();
            String fileMime = downloaded.get("file_mime").asText();
            storeFileOperation.createOrGetStoreFile(fileHash, fileSize, storeType, fileBucket, fileKey, fileMime);
            //Know Hash, torrentId, move user's offline task.

        });
    }

    @Autowired
    public void setStoreFileOperation(StoreFileOperation storeFileOperation) {
        this.storeFileOperation = storeFileOperation;
    }

    private StoreFileOperation storeFileOperation;
}
