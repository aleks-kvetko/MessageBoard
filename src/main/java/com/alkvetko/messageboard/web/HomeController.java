package com.alkvetko.messageboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for home page
 * @author ALEKSANDR KVETKO
 */
@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController {

    /**
     * Opens home page
     * @return view name of home page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }
}
