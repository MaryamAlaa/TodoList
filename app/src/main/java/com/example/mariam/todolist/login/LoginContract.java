package com.example.mariam.todolist.login;

/**
 * Created by Domtyyyyyy on 9/12/2017.
 */

interface LoginContract {
    interface View {
        //  void showProressDaialog();

        void navigateToTodoActivity();

        void navigateToRegisterActivity();

        void showErrorMsg(String s);

        // void hideProgressDialaog();

    }

    interface Presenter {
        void onSignInClicked(String email, String password);

        void onSignUpClicked();

      //  void loginAuthentication(String email, String password);

    }

}
