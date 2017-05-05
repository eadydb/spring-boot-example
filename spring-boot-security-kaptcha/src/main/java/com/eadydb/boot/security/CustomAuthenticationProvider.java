package com.eadydb.boot.security;

import com.eadydb.boot.entity.User;
import com.eadydb.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
* @Author eadydb {dengbin1201@163.com}
* @Date 17-5-5 下午2:47
* <p>
* @Description 自定义验证方式
**/
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        User user = null;
        if (username != null && !"".equals(username)) {
            user = userMapper.findByUsername(username);
        }

        if (user == null) {
            throw new UsernameNotFoundException("用户名/密码无效");
        }
        // 其他验证判断
        grantedAuths.add(new SimpleGrantedAuthority(user.getRole()));
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("用户名/密码无效");
        }
        // 授权
        return new UsernamePasswordAuthenticationToken(username, password, grantedAuths);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
