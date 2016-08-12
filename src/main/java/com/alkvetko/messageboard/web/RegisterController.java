package com.alkvetko.messageboard.web;

import com.alkvetko.messageboard.entity.User;
import com.alkvetko.messageboard.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Controller for registration page
 * @author ALEKSANDR KVETKO
 */
@Controller
@RequestMapping(value = {"/register"})
public class RegisterController {

    private static final Logger logger = Logger.getLogger(RegisterController.class);
    @Autowired
    UserService userService;

    /**
     * Opens registration page
     * @param model
     * @return view name of registration page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Adds new user in the users database if there's no errors and redirects to login page or
     * redirects to register page if there's errors
     * @param user user to be saved
     * @param errors
     * @param model
     * @return redirects to login page with parameter regsuccess if there's no errors or
     * redirects to register page if there's errors
     */
    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, Errors errors, Model model) {
        if(userService.isUsernameExist(user.getUsername())) {
            errors.rejectValue("username", "error.useralreadyexist");
        }
        if (errors.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        if(logger.isDebugEnabled()) {
            logger.debug("New user was created, login: "+user.getUsername());
        }

        return "redirect:/login?regsuccess";
    }
}
