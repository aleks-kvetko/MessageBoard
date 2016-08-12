package com.alkvetko.messageboard.data;

import com.alkvetko.messageboard.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC implementation of interface {@link UserRepository}
 * @author ALEKSANDR KVETKO
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcOperations jdbc;

    public void setRoleForUsername(String role, String username) {
        jdbc.update(
                "insert into user_roles (username, role )" +
                        " values (?, ?)", username, role);


    }

    public void save(User user) {
        jdbc.update(
                "insert into users (username, password, enabled, firstname, lastname, email )" +
                        " values (?, ?, ?, ?, ?, ?)",
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail());


    }

    public boolean isUsernameExists(String username) {
        Integer result = jdbc.queryForObject(
                "SELECT EXISTS(SELECT * FROM users WHERE username = ? )", Integer.class, username);
        return result == 1 ? true : false;
    }

    public User getUserByUsername(String username) {
        return (User) jdbc.queryForObject("SELECT * FROM users WHERE username = '" + username + "'", new Object[]{}, new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("enabled"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"));
        }
    }
}
