package com.eadydb.boot.validator;

import com.eadydb.boot.entity.UserProfile;
import com.eadydb.boot.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 6/14/17 10:25 AM
 * <p/>
 * @DESCRIPTION
 **/
@Component
public class UserProfileValidator implements Validator {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserProfile.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserProfile userProfile = (UserProfile) o;
        existsName(userProfile, errors);
    }

    private void existsName(UserProfile userProfile, Errors errors) {
        if (userProfileRepository.findByName(userProfile.getName()) != null) {
            errors.rejectValue("name", "exists_name", "这个名称已经注册过");
        }
    }
}
