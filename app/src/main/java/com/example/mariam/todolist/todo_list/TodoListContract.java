package com.example.mariam.todolist.todo_list;

import com.example.mariam.todolist.data.TodoItem;

import java.util.List;

/**
 * Created by Domtyyyyyy on 9/19/2017.
 */

public class TodoListContract {
    interface View
    {
        void navigateToAddItem();
        void show(List<TodoItem> todoItems);
        void navigateTOUserList();

    }
    interface  Presenter
    {
        void listReady();
        void onFabClicked();
        void onUserSelected(String emailUser);
        void itemSelected(TodoItem item);
    }

}
