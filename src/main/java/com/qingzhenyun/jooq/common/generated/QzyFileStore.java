/*
 * This file is generated by jOOQ.
*/
package com.qingzhenyun.jooq.common.generated;


import com.qingzhenyun.jooq.common.generated.tables.OfflineFile;
import com.qingzhenyun.jooq.common.generated.tables.StoreFile;
import com.qingzhenyun.jooq.common.generated.tables.User;
import com.qingzhenyun.jooq.common.generated.tables.UserFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class QzyFileStore extends SchemaImpl {

    private static final long serialVersionUID = 1295497067;

    /**
     * The reference instance of <code>qzy_file_store</code>
     */
    public static final QzyFileStore QZY_FILE_STORE = new QzyFileStore();

    /**
     * The table <code>qzy_file_store.offline_file</code>.
     */
    public final OfflineFile OFFLINE_FILE = com.qingzhenyun.jooq.common.generated.tables.OfflineFile.OFFLINE_FILE;

    /**
     * The table <code>qzy_file_store.store_file</code>.
     */
    public final StoreFile STORE_FILE = com.qingzhenyun.jooq.common.generated.tables.StoreFile.STORE_FILE;

    /**
     * The table <code>qzy_file_store.user</code>.
     */
    public final User USER = com.qingzhenyun.jooq.common.generated.tables.User.USER;

    /**
     * The table <code>qzy_file_store.user_file</code>.
     */
    public final UserFile USER_FILE = com.qingzhenyun.jooq.common.generated.tables.UserFile.USER_FILE;

    /**
     * No further instances allowed
     */
    private QzyFileStore() {
        super("qzy_file_store", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            OfflineFile.OFFLINE_FILE,
            StoreFile.STORE_FILE,
            User.USER,
            UserFile.USER_FILE);
    }
}
