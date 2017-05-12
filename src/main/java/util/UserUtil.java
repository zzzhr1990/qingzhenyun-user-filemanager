package util;

import com.qingzhenyun.exception.ApiException;
import com.qingzhenyun.jooq.common.generated.Tables;
import com.qingzhenyun.jooq.common.generated.tables.pojos.User;
import org.jooq.DSLContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * HOO
 * Created by guna on 2017/5/13.
 */
@Component
public class UserUtil implements ApplicationContextAware {

    public static User getUserInSession() {
        return getUserById(1);
    }

    public static User getUserById(Integer id) {
        if (dslContext == null) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "DSL_NOT_READY");
        }
        User user = dslContext.fetchOne(Tables.USER, Tables.USER.ID.eq(id)).into(User.class);
        if (user == null) {
            throw new ApiException(HttpStatus.UNAUTHORIZED, "USER_NOT_FOUND");
        }
        if (user.getStatus() == 10) {
            throw new ApiException(HttpStatus.UNAUTHORIZED, "USER_BANNED");
        }
        return user;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        UserUtil.dslContext = applicationContext.getBean(DSLContext.class);
    }

    private static DSLContext dslContext;
}