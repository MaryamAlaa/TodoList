package com.example.mariam.todolist.todo_list;

import com.example.mariam.todolist.callbacks.IShare;
import com.example.mariam.todolist.data.TodoItem;

/**
 * Created by Domtyyyyyy on 9/19/2017.
 */

public class TodoListPresenter implements TodoListContract.Presenter {
    TodoListContract.View view;
    TodoListModel model;
    IShare iShare;



    public TodoListPresenter(TodoListContract.View view) {
        this.view = view;
        model = new TodoListModel();
    }

    @Override
    public void listReady() {
        model.displayUserList().subscribe(todoItems -> view.show(todoItems));
    }

    @Override
    public void onFabClicked() {
        view.navigateToAddItem();
    }

    @Override
    public void onUserSelected(String emailUser) {
        iShare.welcomeBack(emailUser);
    }

    @Override
    public void itemSelected(TodoItem item) {
        view.navigateTOUserList();
        iShare = s -> model.shareItem(s, item).subscribe();
    }


}
