package com.eadydb.boot;

import com.eadydb.boot.domain.User;
import com.eadydb.boot.domain.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dengbin on 16-11-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = userMapper.findByUsername("dengbin");
        System.out.println(user);
    }
}
