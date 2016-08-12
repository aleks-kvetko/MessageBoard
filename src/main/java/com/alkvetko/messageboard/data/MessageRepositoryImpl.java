package com.alkvetko.messageboard.data;

import com.alkvetko.messageboard.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBC implementation of interface {@link MessageRepository}
 * @author ALEKSANDR KVETKO
 */
@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private JdbcOperations jdbc;

    public void save(Message message) {
        jdbc.update(
                "insert into Messages (text,username, datetime )" +
                        " values (?, ?, ?)",
                message.getText(),
                message.getUsername(),
                message.getDatetime());

    }

    public List<Message> getMessages() {
        return jdbc.query(
                "select id, text, datetime, username" +
                        " from Messages order by id desc",
                new MessageRowMapper());
    }

    public List<Message> getMessagesByUsername(String username) {
        return jdbc.query(
                "select id, text, datetime, username" +
                        " from Messages where username='" + username + "'order by id desc",
                new MessageRowMapper());
    }

    public Message getMessageById(int id) {
        List<Message> messages = jdbc.query(
                "select id, text, datetime, username" +
                        " from Messages where id='" + id + "'",
                new MessageRowMapper());
        if (messages.size() == 0) return null;
        return messages.get(0);
    }

    public void deleteMessageById(int id) {
        jdbc.update("delete from messages where id=" + id);

    }

    public void editMessageTextById(int id, String text) {
        jdbc.update("update messages set text=? where id=?", text, id);
    }


    private static class MessageRowMapper implements RowMapper<Message> {
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Message(
                    rs.getLong("id"),
                    rs.getString("text"),
                    rs.getString("datetime"),
                    rs.getString("username"));
        }
    }
}
