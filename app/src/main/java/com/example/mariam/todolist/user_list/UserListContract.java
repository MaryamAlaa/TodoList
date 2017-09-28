package com.example.mariam.todolist.user_list;

import com.example.mariam.todolist.data.User;

import java.util.List;

/**
 * Created by Domtyyyyyy on 9/19/2017.
 */

public class UserListContract {
    interface View{
        void show(List<User> user);
       void navigateToTodoActivity(User user);
    }
    interface Presenter{
        void setUserList();
        void onUserClicked(User user);
    }
}
