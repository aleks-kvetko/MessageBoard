package com.alkvetko.messageboard.service;

import com.alkvetko.messageboard.data.UserRepository;
import com.alkvetko.messageboard.entity.User;

/**
 * Service interface which provides methods for work with {@link User} objects and {@link UserRepository}
 * @author ALEKSANDR KVETKO
 */
public interface UserService {

    /**
     * Checks if is there a user in the database with definite username
     * @param username
     * @return TRUE(user exist) FALSE(user doesn't exist)
     */
    boolean isUsernameExist(String username);

    /**
     * Saves user into database
     * @param user user to be saved
     */
    void saveUser(User user);

    /**
     * Reads user with definite username
     * @param username
     * @return user object or NULL if user doesn't exist
     */
    User getUserByUsername(String username);


}
