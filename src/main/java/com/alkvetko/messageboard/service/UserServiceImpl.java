package com.alkvetko.messageboard.service;

import com.alkvetko.messageboard.data.UserRepository;
import com.alkvetko.messageboard.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of interface {@link UserService}
 * @author ALEKSANDR KVETKO
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    public boolean isUsernameExist(String username) {
        try {
            if (userRepository.isUsernameExists(username)) {
                return true;
            }

        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
        return false;
    }
    public void saveUser(User user) {
        try {
            user.setEnabled(1);
            userRepository.save(user);
            userRepository.setRoleForUsername("ROLE_USER",user.getUsername());
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
        }
    }

    public User getUserByUsername(String username) {
        try {
            User user=userRepository.getUserByUsername(username);
            return user;
        } catch (Exception e) {
            logger.error(e.getMessage(),e.getCause());
            return null;
        }
    }
}
