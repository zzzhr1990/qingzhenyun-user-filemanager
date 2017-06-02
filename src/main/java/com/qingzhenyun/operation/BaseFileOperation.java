package com.qingzhenyun.operation;

import com.qingzhenyun.common.constant.CommonFileConst;
import com.qingzhenyun.jooq.common.generated.Tables;
import com.qingzhenyun.jooq.common.generated.tables.pojos.UserFile;
import com.qingzhenyun.jooq.common.generated.tables.records.UserFileRecord;
import com.qingzhenyun.service.AbstractDslService;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * BQ
 * Created by guna on 2017/5/13.
 */
public abstract class BaseFileOperation extends AbstractDslService {

    public UserFile createUserFile(String fileName, Integer fileType, long fileSize, String parentId, Integer userId, Integer internal) {
        return createUserFile(fileName, fileType, fileSize, parentId, userId, internal, null, null);
    }

    public UserFile createUserFile(String fileName, Integer fileType, long fileSize, String parentId, Integer userId, Integer internal, String fileId, String mime) {
        UserFileRecord userFileRecord = dslContext.newRecord(Tables.USER_FILE);
        Long current = System.currentTimeMillis();
        userFileRecord.setCreateTime(current);
        userFileRecord.setEditTime(current);
        userFileRecord.setId(UUID.randomUUID().toString());
        userFileRecord.setIsDirectory(fileType);
        userFileRecord.setFileName(fileName);
        userFileRecord.setInternal(internal);
        userFileRecord.setParentId(parentId);
        userFileRecord.setSize(fileSize);
        userFileRecord.setUserId(userId);
        userFileRecord.setStatus(CommonFileConst.FILE_STATUS_NORMAL);
        if (!StringUtils.isEmpty(fileId)) {
            userFileRecord.setMime(fileId);
        }
        if (!StringUtils.isEmpty(mime)) {
            userFileRecord.setMime(mime);
        }
        userFileRecord.store();
        return userFileRecord.into(UserFile.class);
    }

    public UserFile getUserFileByName(String storeFileName, String parentId, Integer userId) {
        UserFileRecord userFileRecord = getUserStoreRecordFileByName(storeFileName, parentId, userId);
        if (userFileRecord == null) {
            return null;
        }
        return userFileRecord.into(UserFile.class);
    }

    public UserFileRecord getUserStoreRecordFileByName(String storeFileName, String parentId, Integer userId) {
        return dslContext.fetchOne(Tables.USER_FILE, Tables.USER_FILE.FILE_NAME.eq(storeFileName)
                .and(Tables.USER_FILE.USER_ID.eq(userId))
                .and(Tables.USER_FILE.PARENT_ID.eq(parentId)));
    }

    public UserFile getUserFileById(String storeFileId, Integer userId) {
        UserFileRecord userFileRecord = (userId == null) ? dslContext.fetchOne(Tables.USER_FILE, Tables.
                USER_FILE.ID.eq(storeFileId))
                :
                dslContext.fetchOne(Tables.USER_FILE, Tables.USER_FILE.ID.eq(storeFileId)
                        .and(Tables.USER_FILE.USER_ID.eq(userId)));
        if (userFileRecord == null) {
            return null;
        }
        return userFileRecord.into(UserFile.class);
    }

    public UserFile getFileById(String storeFileId) {
        return getUserFileById(storeFileId, null);
    }
}
