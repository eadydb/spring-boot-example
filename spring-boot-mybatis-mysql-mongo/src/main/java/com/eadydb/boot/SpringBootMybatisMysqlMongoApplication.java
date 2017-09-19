package com.eadydb.boot;

import com.eadydb.boot.pojo.mongo.MongoUser;
import com.eadydb.boot.pojo.mysql.MysqlUser;
import com.eadydb.boot.service.mongo.MongoUserService;
import com.eadydb.boot.service.mysql.MysqlUserService;
import com.eadydb.boot.service.redis.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "dbconn.properties")
public class SpringBootMybatisMysqlMongoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootMybatisMysqlMongoApplication.class);
		ApplicationContext ctx = app.run(args);

		MysqlUserService mysqlUserService = (MysqlUserService)ctx.getBean("mysqlUserService");
		MysqlUser su = new MysqlUser("shihuc", "SW", 30 , "wuhan");
		mysqlUserService.addUser(su);
		MysqlUser ue = mysqlUserService.getUser(1);
		System.out.println("Mysql User: " + ue);

		MongoUserService mongoUserService = (MongoUserService)ctx.getBean("mongoUserService");
		MongoUser mu = new MongoUser("shihuc", "SW", 30 , "wuhan");
		mongoUserService.addUser(mu);
		MongoUser um = mongoUserService.getUser("shihuc");
		System.out.println("Mongo User: " + um);

		RedisService redisService = (RedisService)ctx.getBean("redisService");
		redisService.putValue("shihuc", "SW coder", 120);
		String value = (String)redisService.getValue("shihuc");
		System.out.println("redis str value: " + value);
	}
}
