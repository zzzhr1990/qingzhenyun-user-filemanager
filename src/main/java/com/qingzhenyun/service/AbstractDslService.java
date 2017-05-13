package com.qingzhenyun.service;

import com.qingzhenyun.jooq.common.generated.tables.pojos.StoreFile;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abs
 * Created by guna on 2017/5/13.
 */
public abstract class AbstractDslService {

    @Autowired
    public void setDslContext(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    protected DSLContext dslContext;
}
