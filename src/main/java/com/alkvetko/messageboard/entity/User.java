package com.alkvetko.messageboard.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * User entity with fields: username, password, enabled, firstname, lastname, email
 * Contains javax validation
 * @author ALEKSANDR KVETKO
 */
public class User {

    @NotNull
    @Size(min=4, max = 40, message = "{Size.user.username}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "{Pattern.user.username}")
    private String username;

    @NotNull
    @Size(min=5, max = 40, message = "{Size.user.password}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "{Pattern.user.password}")
    private String password;

    
    private int enabled;

    @NotNull
    @Size( min=2, max = 40, message = "{Size.user.firstname}" )
    private String firstname;

    @NotNull
    @Size(min=2, max = 40, message = "{Size.user.lastname}")
    private String lastname;

    @NotNull
    @Size(min=6, max = 40, message = "{Size.user.email}")
    @Pattern(regexp = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$",message = "{Pattern.user.email}")
    private String email;

    public User(String username, String password, int enabled, String firstname, String lastname, String email) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(String username, String password, String firstname, String lastname, String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User() {
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
