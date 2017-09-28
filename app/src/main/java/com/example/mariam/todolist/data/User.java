package com.example.mariam.todolist.data;

/**
 * Created by Domtyyyyyy on 9/6/2017.
 */

public class User {
    String uid, email;

    public User() {
    }

    public User(String email, String uid) {
        this.uid = uid;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }
}
