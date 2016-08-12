package com.alkvetko.messageboard.web;

import com.alkvetko.messageboard.entity.Message;
import com.alkvetko.messageboard.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Controller for work with {@link Message} objects
 * @author ALEKSANDR KVETKO
 */
@Controller
@RequestMapping("/messages")
public class MessagesController {

    private static final Logger logger = Logger.getLogger(MessagesController.class);
    @Autowired
    private MessageService messageService;

    /**
     * Opens messages page with all messages
     * @param model
     * @param longmessage string parameter redirected from add method if entered message is too long
     * @return view name of messages page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showMessages(Model model, @ModelAttribute("longmessage") String longmessage) {
        try {
            model.addAttribute("messages", messageService.getMessages());
            model.addAttribute("longmessage", longmessage);
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return "messages";
    }

    /**
     * Deletes message with definite id and redirects to messages page
     * @param id id of message to be deleted
     * @return redirects to messages page
     */
    @RequestMapping("/delete/{id}")
    public String deleteMessageById(@PathVariable int id) {
        try {
            messageService.deleteMessageById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return "redirect:/messages";
    }

    /**
     * Opens page with messages of definite user
     * @param username
     * @param model
     * @return view name of user messages page
     */
    @RequestMapping("/{username}")
    public String getMessagesByUsername(@PathVariable String username, Model model) {
        try {
            model.addAttribute("messages", messageService.getMessagesByUsername(username));
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return "usermessages";
    }

    /**
     * Provides validation and adds new message
     * @param message text of the message
     * @param errors
     * @param model
     * @param redirectAttributes
     * @return redirects to messages page
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveMessage(@Valid Message message, Errors errors, Model model, RedirectAttributes redirectAttributes) {
        try {
            if (errors.hasErrors()) {
                redirectAttributes.addFlashAttribute("longmessage", message.getText());
                redirectAttributes.addFlashAttribute("hasError", true);
            } else {
                messageService.saveMessage(message);

            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return "redirect:/messages";

    }

    /**
     * Opens edit page with message text to be edited
     * @param id id of message to be edited
     * @param model
     * @return view name of edit message page
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editMessage(@PathVariable int id, Model model) {
        try {
            Message message=messageService.getMessageById(id);
            if (message!=null) {
                model.addAttribute("message", message.getText());
                model.addAttribute("username", message.getUsername());
            } else {
                model.addAttribute("error", true);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return "editmessage";
    }

    /**
     * Edits message text and redirects to messages page or redirects to edit page if message isn't valid
     * @param id id of message to be edited
     * @param message text of message
     * @param redirectAttributes
     * @return redirects to messages page if message is valid or redirects to edit page if message isn't valid
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editMessage(@PathVariable int id, String message, RedirectAttributes redirectAttributes) {
        try {
            if (!messageService.isValidEditedText(message)) {
                redirectAttributes.addFlashAttribute("hasError", true);
                return "redirect:/messages/edit/{id}";
            }
            messageService.editMessageTextById(id,message);
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return "redirect:/messages";
    }


}
