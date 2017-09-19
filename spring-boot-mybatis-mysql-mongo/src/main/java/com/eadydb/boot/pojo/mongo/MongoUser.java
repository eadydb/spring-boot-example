package com.eadydb.boot.pojo.mongo;

import com.eadydb.boot.pojo.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:41
 * <p/>
 * @Description
 */
@Data
@Document(collection = "user")
@CompoundIndexes(@CompoundIndex(name = "username", def = "{username:1}"))
public class MongoUser extends User {

    @Id
    private String id;

    public MongoUser(String username, String job, int age, String homeTown) {
        this.username = username;
        this.job = job;
        this.age = age;
        this.homeTown = homeTown;
    }
}
