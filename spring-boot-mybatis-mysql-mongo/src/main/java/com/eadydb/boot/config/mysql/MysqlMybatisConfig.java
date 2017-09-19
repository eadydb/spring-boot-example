package com.eadydb.boot.config.mysql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author eadydb
 * @Date 17-9-19 下午2:24
 * <p/>
 * @Description
 */
@Configuration
@MapperScan(basePackages = "com.eadydb.boot.dao.mysql")
public class MysqlMybatisConfig {

    @Autowired
    @Qualifier("mysqlIds")
    private DataSource mysqlIds;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mysqlIds);
        return sessionFactory.getObject();
    }
}
