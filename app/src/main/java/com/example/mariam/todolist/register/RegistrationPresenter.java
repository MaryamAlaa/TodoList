package com.example.mariam.todolist.register;

/**
 * Created by Domtyyyyyy on 9/12/2017.
 */

class RegistrationPresenter implements RegistrationContract.Presenter {
    private RegistrationContract.View view;
    AddRegisteredUser user;

    RegistrationPresenter(RegistrationContract.View view) {
        this.view = view;
        user  = new AddRegisteredUser();
    }

    @Override
    public void onSignUpClicked(String email, String password) {
        user.addUserToDb(email,password).subscribe(() -> view.navigateToTodoActivity(),throwable -> view.showErrorMsg(throwable.getMessage()));

    }
}
