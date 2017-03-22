package com.example;

/**
 * Created by Administrator on 2017-03-21.
 */
public class HandMessage {

    private int id;
    private String name;
    private String message;
    private String room;
    private String date;

    public HandMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HandMessage(int id, String name, String message, String room, String date) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.room = room;
        this.date = date;
    }

    public HandMessage(String name, String message, String room) {
        this.name = name;
        this.message = message;
        this.room = room;
    }

    public HandMessage(String name) {
        this.name = name;
    }
}
