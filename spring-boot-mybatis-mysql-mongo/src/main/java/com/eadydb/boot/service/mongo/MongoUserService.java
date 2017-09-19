package com.eadydb.boot.service.mongo;

import com.eadydb.boot.dao.mongo.MongoUserRepository;
import com.eadydb.boot.pojo.mongo.MongoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:56
 * <p/>
 * @Description
 */
@Service("mongoUserService")
public class MongoUserService {

    @Autowired
    private MongoUserRepository mongoUserRepository;

    public void addUser(MongoUser user){
        mongoUserRepository.addUser(user);
    }

    public MongoUser getUser(String username){
        return mongoUserRepository.getUser(username);
    }
}
