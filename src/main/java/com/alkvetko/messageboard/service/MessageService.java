package com.alkvetko.messageboard.service;

import com.alkvetko.messageboard.entity.Message;
import com.alkvetko.messageboard.data.MessageRepository;

import java.util.List;

/**
 * Service interface which provides methods for work with {@link Message} objects and {@link MessageRepository}
 * @author ALEKSANDR KVETKO
 */
public interface MessageService {

    /**
     * Reads all messages ordered by id
     * @return list of all messages
     */
    List<Message> getMessages();

    /**
     * Deletes message with definite id
     * @param id
     */
    void deleteMessageById(int id);

    /**
     * Reads messages from database for definite user
     * @param username
     * @return list of messages
     */
    List<Message> getMessagesByUsername(String username);

    /**
     * Saves message into database
     * @param message message to be saved
     */
    void saveMessage(Message message);

    /**
     * Reads message with definite id
     * @param id id of a message
     * @return message object or NULL if message doesn't exist
     */
    Message getMessageById(int id);

    /**
     * Inserts new text for message with definite id
     * @param id id of a message
     * @param text new text
     */
    void editMessageTextById(int id,String text);

    /**
     * Checks if a message has a valid size
     * @param message
     * @return TRUE (valid) FALSE( not valid)
     */
    boolean isValidEditedText(String message);

}
