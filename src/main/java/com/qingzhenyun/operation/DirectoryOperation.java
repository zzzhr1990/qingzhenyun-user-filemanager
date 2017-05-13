package com.qingzhenyun.operation;

import com.qingzhenyun.constans.DirectoryConst;
import com.qingzhenyun.constans.CommonFileConst;
import com.qingzhenyun.jooq.common.generated.Tables;
import com.qingzhenyun.jooq.common.generated.tables.pojos.UserFile;
import com.qingzhenyun.jooq.common.generated.tables.records.UserFileRecord;
import com.qingzhenyun.service.AbstractDslService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * HoHo
 * Created by guna on 2017/5/13.
 */
@Service
public class DirectoryOperation extends BaseFileOperation {

    public UserFile createOrGetDirectory(String directoryName, Integer userId) {
        return createOrGetDirectory(directoryName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId, DirectoryConst.NORMAL_DIRECTORY);

    }

    public UserFile createOrGetDirectory(String directoryName, String parentId, Integer userId) {
        return createOrGetDirectory(directoryName, parentId, userId, DirectoryConst.NORMAL_DIRECTORY);

    }

    public UserFile createOrGetDirectory(String directoryName, Integer userId, Integer internal) {
        return createOrGetDirectory(directoryName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId, internal);

    }

    public UserFile createOrGetDirectory(String directoryName, String parentId, Integer userId, Integer internal) {
        UserFile file = getDirectoryByName(directoryName, parentId, userId);
        if (file == null) {
            file = createUserFile(directoryName, CommonFileConst.DIRECTORY,
                    0L, parentId, userId, internal);
        }
        return file;
    }

    public boolean isDirectoryExists(String directoryName, Integer userId) {
        return isDirectoryExists(directoryName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId);
    }

    public boolean isDirectoryExists(String directoryName, String parentId, Integer userId) {
        return getDirectoryByName(directoryName, parentId, userId) != null;
    }

    public UserFile getDirectoryByName(String directoryName, Integer userId) {
        return getDirectoryByName(directoryName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId);
    }

    public UserFile getDirectoryByName(String directoryName, String parentId, Integer userId) {
        return super.getUserFileByName(directoryName, parentId, userId);
    }

    public UserFile getDirectoryById(String directoryId, Integer userId) {
        return super.getUserFileById(directoryId, userId);
    }
}
