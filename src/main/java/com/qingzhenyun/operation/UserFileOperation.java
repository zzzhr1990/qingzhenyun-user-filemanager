package com.qingzhenyun.operation;

import com.qingzhenyun.common.constant.CommonFileConst;
import com.qingzhenyun.common.constant.DirectoryConst;
import com.qingzhenyun.common.entity.ApiResults;
import com.qingzhenyun.common.exception.ApiException;
import com.qingzhenyun.jooq.common.generated.tables.pojos.UserFile;
import com.qingzhenyun.jooq.common.generated.tables.records.UserFileRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Here, We Use User File Operation
 * Created by guna on 2017/5/13.
 */
@Service
public class UserFileOperation extends BaseFileOperation {

    public UserFile createFileUntilFileNameNotDuplicate(String fileName, String fileId, long fileSize, String parentId, Integer userId, String mime) {
        UserFile fileByName = getFileByName(fileName, parentId, userId);
        int count = 0;
        while (fileByName != null) {
            Integer idx = fileName.lastIndexOf('.');
            if (idx > -1) {
                fileName = appendText(fileName.substring(0, idx), count) + fileName.substring(idx);
            } else {
                fileName = appendText(fileName, count);
            }
            count++;
            fileByName = getFileByName(fileName, parentId, userId);
        }
        return createUserFile(fileName, CommonFileConst.FILE,
                fileSize, parentId, userId, DirectoryConst.NORMAL_DIRECTORY, fileId, mime);
    }

    public UserFile createFileAndThrowErrorWhenDuplicate(String fileName, String fileId, long fileSize, String parentId, Integer userId, String mime) {
        UserFile fileByName = getFileByName(fileName, parentId, userId);
        if (fileByName != null) {
            throw new ApiException(ApiResults.INSUFFICIENT_STORAGE, "FILE_ALREADY_EXISTS");
        }
        return createUserFile(fileName, CommonFileConst.FILE,
                fileSize, parentId, userId, DirectoryConst.NORMAL_DIRECTORY, fileId, mime);
    }

    public UserFile createFileAndIgnoreWhenDuplicate(String fileName, String fileId, long fileSize, String parentId, Integer userId, String mime) {
        UserFile fileByName = getFileByName(fileName, parentId, userId);
        if (fileByName != null) {
            return fileByName;
        }
        return createUserFile(fileName, CommonFileConst.FILE,
                fileSize, parentId, userId, DirectoryConst.NORMAL_DIRECTORY, fileId, mime);
    }

    public UserFile createFileAndRewriteWhenDuplicate(String fileName, String fileId, long fileSize, String parentId, Integer userId, String mime) {
        UserFileRecord userStoreRecordFileByName = getUserStoreRecordFileByName(fileName, parentId, userId);
        if (userStoreRecordFileByName != null) {
            if (fileId.equals(userStoreRecordFileByName.getFileId())) {
                return userStoreRecordFileByName.into(UserFile.class);
            } else {
                userStoreRecordFileByName.setFileId(fileId);
                userStoreRecordFileByName.setEditTime(System.currentTimeMillis());
                userStoreRecordFileByName.store();
                return userStoreRecordFileByName.into(UserFile.class);
            }
            //throw new ApiException(HttpStatus.SC_INSUFFICIENT_STORAGE,"FILE_ALREADY_EXISTS");

        }
        return createUserFile(fileName, CommonFileConst.FILE,
                fileSize, parentId, userId, DirectoryConst.NORMAL_DIRECTORY, fileId, mime);
    }

    private String appendText(String fileName, int count) {
        if (fileName.length() > 60) {
            return fileName.substring(0, 60) + "-" + UUID.randomUUID().toString();
        }
        if (count < 3) {
            return fileName + "(1)";
        } else {
            return fileName + "(" + UUID.randomUUID().toString() + ")";
        }
    }

    public UserFile createFile(String fileName, String fileId, long fileSize, String parentId, Integer userId, String mime) {
        return createUserFile(fileName, CommonFileConst.FILE,
                fileSize, parentId, userId, DirectoryConst.NORMAL_DIRECTORY, fileId, mime);
    }

    public UserFile createFile(String fileName, long fileSize, String parentId, Integer userId) {
        return createUserFile(fileName, CommonFileConst.FILE,
                fileSize, parentId, userId, DirectoryConst.NORMAL_DIRECTORY);
    }

    public UserFile createFile(String fileName, long fileSize, Integer userId, String fileId, String mime) {
        return createUserFile(fileName, CommonFileConst.FILE,
                fileSize, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId, DirectoryConst.NORMAL_DIRECTORY, fileId, mime);
    }

    public boolean isFileExists(String fileName, Integer userId) {
        return isFileExists(fileName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId);
    }

    public boolean isFileExists(String fileName, String parentId, Integer userId) {
        return getFileByName(fileName, parentId, userId) != null;
    }

    public UserFile getFileByName(String fileName, Integer userId) {
        return getFileByName(fileName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId);
    }

    public UserFile getFileByName(String fileName, String parentId, Integer userId) {
        return getUserFileByName(fileName, parentId, userId);
    }

    public UserFile getFileById(String fileId, Integer userId) {
        return super.getUserFileById(fileId, userId);
    }

    public UserFile getFileById(String directoryId) {
        return super.getFileById(directoryId);
    }
}
