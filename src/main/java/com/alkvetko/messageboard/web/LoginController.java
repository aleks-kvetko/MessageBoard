package com.alkvetko.messageboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for login page
 * @author ALEKSANDR KVETKO
 */
@Controller
public class LoginController {
    /**
     * Opens login page
     * @param error request parameter appears if user have entered wrong credentials
     * @param logout logout parameter appears after redirect to the login page after clicking "logout" link
     * @param regsuccess regsuccess parameter appears after redirect to the login page from register page
     * @param model
     * @return view name of login page
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        @RequestParam(value = "regsuccess", required = false) String regsuccess,Model model) {
        if (error != null) {
            model.addAttribute("error", true);
        }

        if (logout != null) {
            model.addAttribute("logout", true);
        }
        if (regsuccess != null) {
            model.addAttribute("regsuccess", true);
        }
        return "login";
    }

}
