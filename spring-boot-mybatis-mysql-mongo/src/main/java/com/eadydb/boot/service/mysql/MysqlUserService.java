package com.eadydb.boot.service.mysql;

import com.eadydb.boot.dao.mysql.IMysqlUser;
import com.eadydb.boot.pojo.mysql.MysqlUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:55
 * <p/>
 * @Description
 */
@Service("mysqlUserService")
public class MysqlUserService {

    @Autowired
    private IMysqlUser mysqlUser;

    public int addUser(MysqlUser userToAdd) {
        return mysqlUser.addUser(userToAdd);
    }

    public MysqlUser getUser(int userId) {
        return mysqlUser.getUser(userId);
    }
}
