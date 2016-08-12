package com.alkvetko.messageboard.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Message entity with fields: id, text, datetime, username
 * Contains javax validation
 * @author ALEKSANDR KVETKO
 */
public class Message {

    private long id;

    @NotNull
    @Size(min = 1, max = 140)
    private String text;

    private String datetime;

    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Message(String text) {
        this.text = text;
        this.datetime = null;
        this.username = null;
    }

    public Message(long id, String text, String datetime, String username) {
        this.id = id;
        this.text = text;
        this.datetime = datetime;
        this.username = username;
    }

    public Message() {
    }
}
