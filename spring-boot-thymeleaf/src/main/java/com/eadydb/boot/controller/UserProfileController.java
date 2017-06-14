package com.eadydb.boot.controller;

import com.eadydb.boot.entity.UserProfile;
import com.eadydb.boot.repository.UserProfileRepository;
import com.eadydb.boot.validator.UserProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 6/14/17 10:07 AM
 * <p/>
 * @DESCRIPTION
 **/
@Controller
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileValidator userProfileValidator;


    @InitBinder
    public void binder(DataBinder binder) {
        binder.addValidators(userProfileValidator);
    }

    @GetMapping("/")
    public String get(ModelMap modelMap) {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        modelMap.addAttribute("userProfiles", userProfiles);
        return "list";
    }

    @GetMapping("/input")
    public String input(ModelMap modelMap) {
        modelMap.addAttribute("userProfile", new UserProfile());
        return "input";
    }

    @PostMapping("/create")
    public String create(@Valid UserProfile userProfile, BindingResult br, ModelMap modelMap) {

        modelMap.addAttribute("userProfile", userProfile);
        if (br.hasErrors()) {
            List<ObjectError> list = br.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "--" + error.getArguments() + "---" + error.getDefaultMessage());
            }
            return "input";
        }
        userProfileRepository.save(userProfile);
        return "redirect:/";

    }

}
