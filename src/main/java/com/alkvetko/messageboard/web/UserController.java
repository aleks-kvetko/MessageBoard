package com.alkvetko.messageboard.web;

import com.alkvetko.messageboard.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alkvetko.messageboard.entity.User;

/**
 * Controller which work with jsp pages and {@link User} objects
 * @author ALEKSANDR KVETKO
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * Opens user profile page for definite user
     * @param username username of user
     * @param model
     * @return view name of user profile page
     */
    @RequestMapping("/{username}")
    public String getUserProfile(@PathVariable String username, Model model) {
        try {
            model.addAttribute("username", username);
            if (userService.isUsernameExist(username)) {
                model.addAttribute("user", userService.getUserByUsername(username));
            } else model.addAttribute("error", true);
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return "userpage";
    }

}
