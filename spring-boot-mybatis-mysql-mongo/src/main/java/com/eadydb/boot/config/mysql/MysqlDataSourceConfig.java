package com.eadydb.boot.config.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:20
 * <p/>
 * @Description
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class MysqlDataSourceConfig {

    @Value("${mysql.driver}")
    private String driver;

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.username}")
    private String username;

    @Value("${mysql.password}")
    private String password;


    @Bean(name="mysqlIds")
    public DataSource mysql(){
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(driver);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        try {
            dataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            log.error("druid datasource initialization failed, e={}", e.getMessage());
            e.printStackTrace();
        }
        return dataSource;
    }

}
