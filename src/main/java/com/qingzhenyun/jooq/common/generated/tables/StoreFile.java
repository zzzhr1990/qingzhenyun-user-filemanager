/*
 * This file is generated by jOOQ.
*/
package com.qingzhenyun.jooq.common.generated.tables;


import com.qingzhenyun.jooq.common.generated.Keys;
import com.qingzhenyun.jooq.common.generated.QzyFileStore;
import com.qingzhenyun.jooq.common.generated.tables.records.StoreFileRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class StoreFile extends TableImpl<StoreFileRecord> {

    private static final long serialVersionUID = 1450905624;

    /**
     * The reference instance of <code>qzy_file_store.store_file</code>
     */
    public static final StoreFile STORE_FILE = new StoreFile();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StoreFileRecord> getRecordType() {
        return StoreFileRecord.class;
    }

    /**
     * The column <code>qzy_file_store.store_file.hash</code>.
     */
    public final TableField<StoreFileRecord, String> HASH = createField("hash", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.size</code>.
     */
    public final TableField<StoreFileRecord, Long> SIZE = createField("size", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.store_type</code>.
     */
    public final TableField<StoreFileRecord, Integer> STORE_TYPE = createField("store_type", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.store_bucket</code>.
     */
    public final TableField<StoreFileRecord, Integer> STORE_BUCKET = createField("store_bucket", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.store_key</code>.
     */
    public final TableField<StoreFileRecord, Integer> STORE_KEY = createField("store_key", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.create_time</code>.
     */
    public final TableField<StoreFileRecord, Long> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.mime</code>.
     */
    public final TableField<StoreFileRecord, String> MIME = createField("mime", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.preview</code>.
     */
    public final TableField<StoreFileRecord, Integer> PREVIEW = createField("preview", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>qzy_file_store.store_file.preview_id</code>.
     */
    public final TableField<StoreFileRecord, String> PREVIEW_ID = createField("preview_id", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.store_file.preview_type</code>.
     */
    public final TableField<StoreFileRecord, Integer> PREVIEW_TYPE = createField("preview_type", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>qzy_file_store.store_file</code> table reference
     */
    public StoreFile() {
        this("store_file", null);
    }

    /**
     * Create an aliased <code>qzy_file_store.store_file</code> table reference
     */
    public StoreFile(String alias) {
        this(alias, STORE_FILE);
    }

    private StoreFile(String alias, Table<StoreFileRecord> aliased) {
        this(alias, aliased, null);
    }

    private StoreFile(String alias, Table<StoreFileRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return QzyFileStore.QZY_FILE_STORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StoreFileRecord> getPrimaryKey() {
        return Keys.KEY_STORE_FILE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StoreFileRecord>> getKeys() {
        return Arrays.<UniqueKey<StoreFileRecord>>asList(Keys.KEY_STORE_FILE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreFile as(String alias) {
        return new StoreFile(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StoreFile rename(String name) {
        return new StoreFile(name, null);
    }
}
