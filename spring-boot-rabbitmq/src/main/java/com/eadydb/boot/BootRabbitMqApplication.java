package com.eadydb.boot;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by dengbin on 16-11-25.
 */
@SpringBootApplication
@EnableScheduling // 启动任务调度
public class BootRabbitMqApplication {

    // rabbit操作类
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Scheduled(fixedDelay = 3000) // 3s执行一次
    public void send() {
        rabbitTemplate.convertAndSend("foo", "spring boot rabbitmq");
    }


    @Bean
    public Queue queue() {
        return new Queue("foo");
    }

    @RabbitListener(queues = "foo")
    public void onMessage(@Payload String foo) {
        System.out.println(">>>new>>>" + new Date() + " : " + foo);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootRabbitMqApplication.class, args);
    }
}