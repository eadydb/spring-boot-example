package com.eaydb.boot.jwt;

import com.eaydb.boot.entity.User;
import com.eaydb.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/8/17 10:34 PM
 * <p/>
 * @DESCRIPTION
 **/
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
