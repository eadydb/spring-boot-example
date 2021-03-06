package com.eadydb.boot.config.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:28
 * <p/>
 * @Description
 */
@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan
@EnableMongoRepositories
public class MongoDataSourceConfig extends AbstractMongoConfiguration {

    @Value("${mongo.database}")
    private String dbname;

    @Value("${mongo.host}")
    private String dbhost;

    @Value("${mongo.port}")
    private String dbport;

    @Value("${mongo.username}")
    private String username;

    @Value("${mongo.password}")
    private String password;

    @Override
    protected String getDatabaseName() {
        return this.dbname;
    }

    public MongoDataSourceConfig(){
        if (null == dbport || "".equalsIgnoreCase(dbport.trim())){
            dbport = "27017";
        }
    }

    @Override
    @Bean(name="mongods")
    public Mongo mongo() throws Exception {
        ServerAddress serverAddress = new ServerAddress(dbhost,Integer.parseInt(dbport));
        //MongoCredential credential = MongoCredential.createMongoCRCredential(username,dbname,password.toCharArray());
        Mongo mongo = new MongoClient(serverAddress);
        return mongo;
    }
}
