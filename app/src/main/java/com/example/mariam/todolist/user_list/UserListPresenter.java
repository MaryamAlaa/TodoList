package com.example.mariam.todolist.user_list;

import com.example.mariam.todolist.data.User;

/**
 * Created by Domtyyyyyy on 9/19/2017.
 */

public class UserListPresenter implements UserListContract.Presenter{
    UserListContract.View view;
    UserListModel model;

    public UserListPresenter(UserListContract.View view) {
        this.view = view;
        model = new UserListModel();
    }

    @Override
    public void setUserList() {
        model.displayUserList().subscribe(users -> view.show(users));
    }

    @Override
    public void onUserClicked(User user) {
        view.navigateToTodoActivity(user);
    }
}
