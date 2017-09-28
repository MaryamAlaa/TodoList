package com.example.mariam.todolist.user_list;

import com.example.mariam.todolist.data.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import durdinapps.rxfirebase2.DataSnapshotMapper;
import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Flowable;

/**
 * Created by Domtyyyyyy on 9/19/2017.
 */

public class UserListModel {
    private FirebaseAuth auth;

    public Flowable<List<User>> displayUserList() {
        auth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        return RxFirebaseDatabase.observeValueEvent(database.getReference().child("Users"), DataSnapshotMapper.listOf(User.class))
                .flatMapSingle((idList) -> Flowable.fromIterable(idList)
                        .filter(str -> !(auth.getCurrentUser().getEmail().equals(str.getEmail())))
                        .toList());
    }
}
