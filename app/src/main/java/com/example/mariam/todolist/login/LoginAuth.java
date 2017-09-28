package com.example.mariam.todolist.login;

import com.example.mariam.todolist.FirebaseAuthentication;
import com.google.firebase.auth.AuthResult;

import io.reactivex.Maybe;

/**
 * Created by Domtyyyyyy on 9/20/2017.
 */

public class LoginAuth {
    public Maybe<AuthResult> login(String email, String password) {
        FirebaseAuthentication firebaseAuthentication = FirebaseAuthentication.getInstance();
        return firebaseAuthentication.signInO(email, password);
    }
}
