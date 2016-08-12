package com.alkvetko.messageboard.data;

import com.alkvetko.messageboard.entity.User;

/**
 * Repository interface for work with {@link User} objects
 * @author ALEKSANDR KVETKO
 */

public interface UserRepository {

    /**
     * Saves user into database
     * @param user user to be saved
     */
    void save(User user);

    /**
     * Read user with definite username
     * @param username
     * @return user object or NULL if user doesn't exist
     */
    User getUserByUsername(String username);

    /**
     * Checks if is there a user in the database with definite username
     * @param username
     * @return TRUE (user exist) FALSE (user doesn't exist)
     */
    boolean isUsernameExists(String username);

    /**
     * Sets role for user with definite username
     * @param role
     * @param username
     */
    void setRoleForUsername(String role,String username);


}
