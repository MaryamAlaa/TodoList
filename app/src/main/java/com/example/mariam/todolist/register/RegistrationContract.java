package com.example.mariam.todolist.register;

/**
 * Created by Domtyyyyyy on 9/12/2017.
 */

public  interface RegistrationContract {
    interface View {
        void navigateToTodoActivity();

     void showErrorMsg(String errorMsg);

    }

    interface Presenter {

        void onSignUpClicked(String email, String password);

     //   void userRegistered(String email);

    }


}
