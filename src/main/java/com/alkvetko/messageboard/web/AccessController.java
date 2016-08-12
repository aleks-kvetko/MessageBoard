package com.alkvetko.messageboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for service pages
 * @author ALEKSANDR KVETKO
 */
@Controller
@RequestMapping(value = {"/403"})
public class AccessController {
    /**
     * Opens 403 access denied page
     * @return view name of 403 access denied page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String accessDeniedPage() {
        return "403";
    }
}
