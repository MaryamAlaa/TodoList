package com.example.mariam.todolist.login;

/**
 * Created by Domtyyyyyy on 9/12/2017.
 */

class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    LoginAuth loginAuth;

    LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
        loginAuth = new LoginAuth();
    }


    @Override
    public void onSignInClicked(String email, String password) {
        loginAuth.login(email, password).subscribe(authResult -> mView.navigateToTodoActivity(), throwable -> mView.showErrorMsg(throwable.getMessage()));
    }

    @Override
    public void onSignUpClicked() {
        mView.navigateToRegisterActivity();
    }

}
