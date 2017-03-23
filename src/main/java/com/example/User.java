package com.example;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2017-03-13.
 */
public class User {
    @NotNull
    @Size(min=2, max=30, message="Nu skrev du lite fel. Username måste minst vara 2 tecken lång eller max 30 tecken lång")
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){
    }
}
