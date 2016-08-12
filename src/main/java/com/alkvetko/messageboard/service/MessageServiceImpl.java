package com.alkvetko.messageboard.service;

import com.alkvetko.messageboard.data.MessageRepositoryImpl;
import com.alkvetko.messageboard.entity.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Implementation of interface {@link MessageService}
 * @author ALEKSANDR KVETKO
 */
@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = Logger.getLogger(MessageServiceImpl.class);
    @Autowired
    MessageRepositoryImpl messageRepository;


    public void editMessageTextById(int id, String text) {
        messageRepository.editMessageTextById(id, text);
    }

    public Message getMessageById(int id) {

        try {
            Message message = messageRepository.getMessageById(id);
            return message;
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
            return null;
        }


    }

    public List<Message> getMessages() {
        List<Message> messages = messageRepository.getMessages();
        return messages;
    }

    public void saveMessage(Message message) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        message.setUsername(username);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"));
        message.setDatetime(time);
        messageRepository.save(message);
    }

    public List<Message> getMessagesByUsername(String username) {
        List<Message> messages = messageRepository.getMessagesByUsername(username);
        return messages;
    }


    public void deleteMessageById(int id) {
        messageRepository.deleteMessageById(id);
    }

    public boolean isValidEditedText(String message) {
        return message.length() > 0 && message.length() <= 180;
    }
}
