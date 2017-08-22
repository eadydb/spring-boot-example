package com.eaydb.boot.repository;

import com.eaydb.boot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 10:40 PM
 * <p/>
 * @DESCRIPTION
 **/
@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByUsername(final String username);

}
