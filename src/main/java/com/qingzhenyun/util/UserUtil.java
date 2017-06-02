package com.qingzhenyun.util;

import com.qingzhenyun.common.entity.ApiResults;
import com.qingzhenyun.common.exception.ApiException;
import com.qingzhenyun.jooq.common.generated.Tables;
import com.qingzhenyun.jooq.common.generated.tables.pojos.User;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserUtil implements ApplicationContextAware {

    public UserUtil() {

    }

    public static Integer ensureUserIdNotNull(Integer userId) {
        if (userId == null) {
            throw new ApiException(ApiResults.BAD_REQUEST, "USER_ID_MISSING");
        }
        return userId;
    }

    public static <T> T ensureDataNotNull(T data, String message) {
        if (data == null) {
            throw new ApiException(ApiResults.BAD_REQUEST, "USER_ID_MISSING");
        }
        return data;
    }
    public static User getUserInSession() {
        return getUserById(1);
    }

    public static User getUserById(Integer id) {
        if (dslContext == null) {
            throw new ApiException(ApiResults.INTERNAL_SERVER_ERROR, "DSL_NOT_READY");
        }
        User user = dslContext.fetchOne(Tables.USER, Tables.USER.ID.eq(id)).into(User.class);
        if (user == null) {
            throw new ApiException(ApiResults.UNAUTHORIZED, "USER_NOT_FOUND");
        }
        if (user.getStatus() == 10) {
            throw new ApiException(ApiResults.UNAUTHORIZED, "USER_BANNED");
        }
        return user;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        UserUtil.dslContext = applicationContext.getBean(DSLContext.class);
    }

    private static DSLContext dslContext;
}
