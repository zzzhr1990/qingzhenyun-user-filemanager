package com.qingzhenyun.operation;

import com.qingzhenyun.constans.DirectoryConst;
import com.qingzhenyun.constans.FileConst;
import com.qingzhenyun.jooq.common.generated.Tables;
import com.qingzhenyun.jooq.common.generated.tables.pojos.UserFile;
import com.qingzhenyun.jooq.common.generated.tables.records.UserFileRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * HoHo
 * Created by guna on 2017/5/13.
 */
@Service
public class DirectoryOperation {

    public UserFile createOrGetDirectory(String directoryName, Integer userId) {
        return createOrGetDirectory(directoryName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId, 0);

    }

    public UserFile createOrGetDirectory(String directoryName, String parentId, Integer userId) {
        return createOrGetDirectory(directoryName, parentId, userId, 0);

    }

    public UserFile createOrGetDirectory(String directoryName, Integer userId, Integer internal) {
        return createOrGetDirectory(directoryName, DirectoryConst.ROOT_DIRECTORY_PARENT_ID, userId, internal);

    }

    public UserFile createOrGetDirectory(String directoryName, String parentId, Integer userId, Integer internal) {
        UserFile file = getDirectoryByName(directoryName, parentId, userId);
        if (file == null) {
            UserFileRecord userFileRecord = dslContext.newRecord(Tables.USER_FILE);
            Long current = System.currentTimeMillis();
            userFileRecord.setCreateTime(current);
            userFileRecord.setEditTime(current);
            userFileRecord.setId(UUID.randomUUID().toString());
            userFileRecord.setIsDirectory(1);
            userFileRecord.setFileName(directoryName);
            userFileRecord.setInternal(internal);
            userFileRecord.setParentId(parentId);
            userFileRecord.setSize(0L);
            userFileRecord.setStatus(FileConst.FILE_STATUS_NORMAL);
            userFileRecord.store();
            file = userFileRecord.into(UserFile.class);
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
        UserFileRecord userFileRecord = dslContext.fetchOne(Tables.USER_FILE, Tables.USER_FILE.FILE_NAME.eq(directoryName)
                .and(Tables.USER_FILE.USER_ID.eq(userId))
                .and(Tables.USER_FILE.PARENT_ID.eq(parentId)));
        if (userFileRecord == null) {
            return null;
        }
        return userFileRecord.into(UserFile.class);
    }

    @Autowired
    public void setDslContext(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    private DSLContext dslContext;
}
