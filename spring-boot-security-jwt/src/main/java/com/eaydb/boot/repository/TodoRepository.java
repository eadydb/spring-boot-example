package com.eaydb.boot.repository;

import com.eaydb.boot.entity.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 11:52 PM
 * <p/>
 * @DESCRIPTION
 **/
@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByUserUsername(String username);
}