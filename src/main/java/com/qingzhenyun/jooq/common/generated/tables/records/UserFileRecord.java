/*
 * This file is generated by jOOQ.
*/
package com.qingzhenyun.jooq.common.generated.tables.records;


import com.qingzhenyun.jooq.common.generated.tables.UserFile;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UserFileRecord extends UpdatableRecordImpl<UserFileRecord> implements Record12<String, String, Long, String, Integer, Integer, Integer, Long, Long, String, String, Integer> {

    private static final long serialVersionUID = 151724560;

    /**
     * Setter for <code>qzy_file_store.user_file.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.file_id</code>.
     */
    public void setFileId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.file_id</code>.
     */
    public String getFileId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.size</code>.
     */
    public void setSize(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.size</code>.
     */
    public Long getSize() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.mime</code>.
     */
    public void setMime(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.mime</code>.
     */
    public String getMime() {
        return (String) get(3);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.is_directory</code>.
     */
    public void setIsDirectory(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.is_directory</code>.
     */
    public Integer getIsDirectory() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.status</code>.
     */
    public void setStatus(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.status</code>.
     */
    public Integer getStatus() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.create_time</code>.
     */
    public void setCreateTime(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.create_time</code>.
     */
    public Long getCreateTime() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.edit_time</code>.
     */
    public void setEditTime(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.edit_time</code>.
     */
    public Long getEditTime() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.parent_id</code>.
     */
    public void setParentId(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.parent_id</code>.
     */
    public String getParentId() {
        return (String) get(9);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.file_name</code>.
     */
    public void setFileName(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.file_name</code>.
     */
    public String getFileName() {
        return (String) get(10);
    }

    /**
     * Setter for <code>qzy_file_store.user_file.internal</code>.
     */
    public void setInternal(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>qzy_file_store.user_file.internal</code>.
     */
    public Integer getInternal() {
        return (Integer) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<String, String, Long, String, Integer, Integer, Integer, Long, Long, String, String, Integer> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<String, String, Long, String, Integer, Integer, Integer, Long, Long, String, String, Integer> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return UserFile.USER_FILE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return UserFile.USER_FILE.FILE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return UserFile.USER_FILE.SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return UserFile.USER_FILE.MIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return UserFile.USER_FILE.IS_DIRECTORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return UserFile.USER_FILE.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return UserFile.USER_FILE.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return UserFile.USER_FILE.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return UserFile.USER_FILE.EDIT_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return UserFile.USER_FILE.PARENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return UserFile.USER_FILE.FILE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return UserFile.USER_FILE.INTERNAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getFileId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getIsDirectory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getEditTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getParentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getFileName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getInternal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value2(String value) {
        setFileId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value3(Long value) {
        setSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value4(String value) {
        setMime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value5(Integer value) {
        setIsDirectory(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value6(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value7(Integer value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value8(Long value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value9(Long value) {
        setEditTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value10(String value) {
        setParentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value11(String value) {
        setFileName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord value12(Integer value) {
        setInternal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFileRecord values(String value1, String value2, Long value3, String value4, Integer value5, Integer value6, Integer value7, Long value8, Long value9, String value10, String value11, Integer value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserFileRecord
     */
    public UserFileRecord() {
        super(UserFile.USER_FILE);
    }

    /**
     * Create a detached, initialised UserFileRecord
     */
    public UserFileRecord(String id, String fileId, Long size, String mime, Integer isDirectory, Integer userId, Integer status, Long createTime, Long editTime, String parentId, String fileName, Integer internal) {
        super(UserFile.USER_FILE);

        set(0, id);
        set(1, fileId);
        set(2, size);
        set(3, mime);
        set(4, isDirectory);
        set(5, userId);
        set(6, status);
        set(7, createTime);
        set(8, editTime);
        set(9, parentId);
        set(10, fileName);
        set(11, internal);
    }
}
