package com.example.mariam.todolist;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import durdinapps.rxfirebase2.RxFirebaseAuth;
import io.reactivex.Maybe;

/**
 * Created by Domtyyyyyy on 8/29/2017.
 */

public class FirebaseAuthentication {
    FirebaseAuth auth;
    private static FirebaseAuthentication ourInstance = new FirebaseAuthentication();

    public static FirebaseAuthentication getInstance() {
        return ourInstance;
    }

    private FirebaseAuthentication() {
        auth = FirebaseAuth.getInstance();
    }

    public Maybe<AuthResult> signInO(String email, String password) {
       return RxFirebaseAuth.signInWithEmailAndPassword(auth,email,password);

    }

    public Maybe<AuthResult> signUpO(String email, String password) {
     return   RxFirebaseAuth.createUserWithEmailAndPassword(auth, email, password);

    }

}
