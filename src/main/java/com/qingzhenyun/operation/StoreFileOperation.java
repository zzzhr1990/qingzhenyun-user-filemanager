package com.qingzhenyun.operation;

import com.qingzhenyun.jooq.common.generated.Tables;
import com.qingzhenyun.jooq.common.generated.tables.pojos.StoreFile;
import com.qingzhenyun.jooq.common.generated.tables.records.StoreFileRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guna on 2017/5/13.
 */
@Service
public class StoreFileOperation {
    public StoreFile createOrGetStoreFile(String hash, Long size,
                                          Integer storeType, String bucket, String key, String mime) {
        StoreFile file = getStoreFile(hash);
        if (file == null) {
            StoreFileRecord storeFileRecord = dslContext.newRecord(Tables.STORE_FILE);
            Long current = System.currentTimeMillis();
            storeFileRecord.setCreateTime(current);
            storeFileRecord.setHash(hash);
            storeFileRecord.setMime(mime);
            storeFileRecord.setPreview(0);
            storeFileRecord.setSize(size);
            storeFileRecord.setStoreBucket(bucket);
            storeFileRecord.setStoreKey(key);
            storeFileRecord.setStoreType(storeType);
            storeFileRecord.store();
            file = storeFileRecord.into(StoreFile.class);
        }
        return file;
    }

    public StoreFile getStoreFile(String hash) {
        return dslContext.fetchOne(Tables.STORE_FILE, Tables.STORE_FILE.HASH.eq(hash)).into(StoreFile.class);
    }

    @Autowired
    public void setDslContext(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    private DSLContext dslContext;
}
