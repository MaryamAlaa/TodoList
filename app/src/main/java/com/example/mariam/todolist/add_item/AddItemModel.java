package com.example.mariam.todolist.add_item;

import com.example.mariam.todolist.data.TodoItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Completable;

/**
 * Created by Domtyyyyyy on 9/17/2017.
 */

public class AddItemModel {

    public Completable addItem(String title, String describtion) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        DatabaseReference ref = database.getReference().child("Items");
        DatabaseReference itemId = ref.push();
        String key = itemId.getKey();
        TodoItem item = new TodoItem(title, describtion, key);
        Completable addItemCompletable = RxFirebaseDatabase.setValue(itemId, item);

        Completable addItemToUserCompletable = RxFirebaseDatabase.setValue(database.getReference()
                .child("Users")
                .child(auth.getCurrentUser().getUid())
                .child("UserItems")
                .child(key), key);
      return  addItemCompletable.andThen(addItemToUserCompletable);
    }


}
