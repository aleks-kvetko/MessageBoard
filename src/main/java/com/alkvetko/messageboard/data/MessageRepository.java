package com.alkvetko.messageboard.data;

import com.alkvetko.messageboard.entity.Message;

import java.util.List;

/**
 * Repository interface for work with {@link Message} objects
 * @author ALEKSANDR KVETKO
 */

public interface MessageRepository {

    /**
     * Saves message into database
     * @param message message to be saved
     */
    void save(Message message);

    /**
     * Reads all messages ordered by id
     * @return list of all messages
     */
    List<Message> getMessages();

    /**
     * Reads messages from database for definite user
     * @param username
     * @return list of messages
     */
    List<Message> getMessagesByUsername(String username);

    /**
     * Deletes message with definite id
     * @param id
     */
    void deleteMessageById(int id);

    /**
     * Inserts new text for message with definite id
     * @param id id of a message
     * @param text new text
     */
    void editMessageTextById(int id, String text);

    /**
     * Reads message with definite id
     * @param id id of message
     * @return message object or null if message doesn't exist
     */
    Message getMessageById(int id);


}
