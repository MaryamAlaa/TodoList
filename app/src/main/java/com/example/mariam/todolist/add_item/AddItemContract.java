package com.example.mariam.todolist.add_item;

/**
 * Created by Domtyyyyyy on 9/17/2017.
 */

public class AddItemContract {
    interface View {
        void onAddItemFinished();
    }

    interface Presenter {
        void onAddItemButtonClicked(String title ,String desc);
    }

}
