/*
 * This file is generated by jOOQ.
*/
package com.qingzhenyun.jooq.common.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OfflineFile implements Serializable {

    private static final long serialVersionUID = 1136909491;

    private String taskId;
    private String taskHash;
    private String fileHash;
    private Long   addTime;

    public OfflineFile() {}

    public OfflineFile(OfflineFile value) {
        this.taskId = value.taskId;
        this.taskHash = value.taskHash;
        this.fileHash = value.fileHash;
        this.addTime = value.addTime;
    }

    public OfflineFile(
        String taskId,
        String taskHash,
        String fileHash,
        Long   addTime
    ) {
        this.taskId = taskId;
        this.taskHash = taskHash;
        this.fileHash = fileHash;
        this.addTime = addTime;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskHash() {
        return this.taskHash;
    }

    public void setTaskHash(String taskHash) {
        this.taskHash = taskHash;
    }

    public String getFileHash() {
        return this.fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public Long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OfflineFile (");

        sb.append(taskId);
        sb.append(", ").append(taskHash);
        sb.append(", ").append(fileHash);
        sb.append(", ").append(addTime);

        sb.append(")");
        return sb.toString();
    }
}
