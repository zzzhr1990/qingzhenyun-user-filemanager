/*
 * This file is generated by jOOQ.
*/
package com.qingzhenyun.jooq.common.generated.tables;


import com.qingzhenyun.jooq.common.generated.Keys;
import com.qingzhenyun.jooq.common.generated.QzyFileStore;
import com.qingzhenyun.jooq.common.generated.tables.records.UserRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
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
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1236389533;

    /**
     * The reference instance of <code>qzy_file_store.user</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>qzy_file_store.user.id</code>.
     */
    public final TableField<UserRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.username</code>.
     */
    public final TableField<UserRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.password</code>.
     */
    public final TableField<UserRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.salt</code>.
     */
    public final TableField<UserRecord, String> SALT = createField("salt", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.level</code>.
     */
    public final TableField<UserRecord, Integer> LEVEL = createField("level", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>qzy_file_store.user.email</code>.
     */
    public final TableField<UserRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.mobile_contry_code</code>.
     */
    public final TableField<UserRecord, String> MOBILE_CONTRY_CODE = createField("mobile_contry_code", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false).defaultValue(org.jooq.impl.DSL.inline("86", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>qzy_file_store.user.mobile_number</code>.
     */
    public final TableField<UserRecord, String> MOBILE_NUMBER = createField("mobile_number", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.used_size</code>.
     */
    public final TableField<UserRecord, Long> USED_SIZE = createField("used_size", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.total_size</code>.
     */
    public final TableField<UserRecord, Long> TOTAL_SIZE = createField("total_size", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.used_bandwidth</code>.
     */
    public final TableField<UserRecord, Integer> USED_BANDWIDTH = createField("used_bandwidth", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.total_bandwidth</code>.
     */
    public final TableField<UserRecord, Integer> TOTAL_BANDWIDTH = createField("total_bandwidth", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.create_time</code>.
     */
    public final TableField<UserRecord, Long> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.last_activate_time</code>.
     */
    public final TableField<UserRecord, Long> LAST_ACTIVATE_TIME = createField("last_activate_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>qzy_file_store.user.last_activate_ip</code>.
     */
    public final TableField<UserRecord, String> LAST_ACTIVATE_IP = createField("last_activate_ip", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

    /**
     * Create a <code>qzy_file_store.user</code> table reference
     */
    public User() {
        this("user", null);
    }

    /**
     * Create an aliased <code>qzy_file_store.user</code> table reference
     */
    public User(String alias) {
        this(alias, USER);
    }

    private User(String alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(String alias, Table<UserRecord> aliased, Field<?>[] parameters) {
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
    public Identity<UserRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.KEY_USER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRecord>>asList(Keys.KEY_USER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User as(String alias) {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(name, null);
    }
}
