/*
 * This file is generated by jOOQ.
*/
package com.qingzhenyun.jooq.common.generated.tables;


import com.qingzhenyun.jooq.common.generated.Keys;
import com.qingzhenyun.jooq.common.generated.QzyFileStore;
import com.qingzhenyun.jooq.common.generated.tables.records.UserFileRecord;

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
public class UserFile extends TableImpl<UserFileRecord> {

    private static final long serialVersionUID = -686928736;

    /**
     * The reference instance of <code>qzy_file_store.user_file</code>
     */
    public static final UserFile USER_FILE = new UserFile();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserFileRecord> getRecordType() {
        return UserFileRecord.class;
    }

    /**
     * The column <code>qzy_file_store.user_file.id</code>.
     */
    public final TableField<UserFileRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.file_id</code>.
     */
    public final TableField<UserFileRecord, String> FILE_ID = createField("file_id", org.jooq.impl.SQLDataType.VARCHAR.length(64), this, "");

    /**
     * The column <code>qzy_file_store.user_file.size</code>.
     */
    public final TableField<UserFileRecord, Long> SIZE = createField("size", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.mime</code>.
     */
    public final TableField<UserFileRecord, String> MIME = createField("mime", org.jooq.impl.SQLDataType.VARCHAR.length(64), this, "");

    /**
     * The column <code>qzy_file_store.user_file.is_directory</code>.
     */
    public final TableField<UserFileRecord, Integer> IS_DIRECTORY = createField("is_directory", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.user_id</code>.
     */
    public final TableField<UserFileRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.status</code>.
     */
    public final TableField<UserFileRecord, Integer> STATUS = createField("status", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.create_time</code>.
     */
    public final TableField<UserFileRecord, Long> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.edit_time</code>.
     */
    public final TableField<UserFileRecord, Long> EDIT_TIME = createField("edit_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.parent_id</code>.
     */
    public final TableField<UserFileRecord, String> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>qzy_file_store.user_file.file_name</code>.
     */
    public final TableField<UserFileRecord, String> FILE_NAME = createField("file_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user_file.internal</code>.
     */
    public final TableField<UserFileRecord, Integer> INTERNAL = createField("internal", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>qzy_file_store.user_file</code> table reference
     */
    public UserFile() {
        this("user_file", null);
    }

    /**
     * Create an aliased <code>qzy_file_store.user_file</code> table reference
     */
    public UserFile(String alias) {
        this(alias, USER_FILE);
    }

    private UserFile(String alias, Table<UserFileRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserFile(String alias, Table<UserFileRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<UserFileRecord> getPrimaryKey() {
        return Keys.KEY_USER_FILE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserFileRecord>> getKeys() {
        return Arrays.<UniqueKey<UserFileRecord>>asList(Keys.KEY_USER_FILE_PRIMARY, Keys.KEY_USER_FILE_IDX_SEARCH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFile as(String alias) {
        return new UserFile(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserFile rename(String name) {
        return new UserFile(name, null);
    }
}
