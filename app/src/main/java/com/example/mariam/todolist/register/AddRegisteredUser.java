package com.example.mariam.todolist.register;

import com.example.mariam.todolist.FirebaseAuthentication;
import com.example.mariam.todolist.data.User;
import com.google.firebase.database.FirebaseDatabase;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Completable;

/**
 * Created by Domtyyyyyy on 9/20/2017.
 */

public class AddRegisteredUser {

    public Completable addUserToDb(String email, String password) {
        //auth
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuthentication firebaseAuthentication = FirebaseAuthentication.getInstance();

        return firebaseAuthentication.signUpO(email, password)
                .flatMapCompletable(authResult -> {
                    User user = new User(authResult.getUser().getEmail(), authResult.getUser().getUid());
                    return RxFirebaseDatabase.setValue(database.getReference().child("Users").child(authResult.getUser().getUid()), user);
                });
//        subscribe(authResult -> authResult.getUser().getUid())
//        //database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//      //  FirebaseAuth auth = FirebaseAuth.getInstance();
//        User user = new User(email, auth.getCurrentUser().getUid());
//        Completable c = RxFirebaseDatabase.setValue(database.getReference().child("Users").child(auth.getCurrentUser().getUid()), user);


    }

}
