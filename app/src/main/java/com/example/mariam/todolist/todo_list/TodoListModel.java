package com.example.mariam.todolist.todo_list;

import com.example.mariam.todolist.data.TodoItem;
import com.example.mariam.todolist.data.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import durdinapps.rxfirebase2.DataSnapshotMapper;
import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by Domtyyyyyy on 9/19/2017.
 */

public class TodoListModel {
    private FirebaseDatabase database;
     FirebaseAuth auth;

    public Flowable<List<TodoItem>> displayUserList() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        DatabaseReference userItemsRef = database.getReference()
                .child("Users")
                .child(auth.getCurrentUser().getUid())
                .child("UserItems");

        DatabaseReference itemsRef = database.getReference().child("Items");

        return RxFirebaseDatabase.observeValueEvent(userItemsRef
                , DataSnapshotMapper.listOf(String.class))
                .flatMapSingle((idList) -> Flowable.fromIterable(idList)
                        .flatMapMaybe(str -> RxFirebaseDatabase.observeSingleValueEvent(itemsRef.child(str), TodoItem.class))
                        .toList());
    }

    public Completable shareItem(String emailUser, TodoItem item) {
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        return RxFirebaseDatabase.observeSingleValueEvent(database.getReference().child("Users"), DataSnapshotMapper.listOf(User.class))
                .flatMapObservable(io.reactivex.Observable::fromIterable)
                .filter(users -> users.getEmail().equals(emailUser))
                .flatMapCompletable(user1 ->
                        RxFirebaseDatabase.setValue(database.getReference().child("Users")
                                .child(user1.getUid()).child("UserItems").push(), item.getItemId()));

    }
}
