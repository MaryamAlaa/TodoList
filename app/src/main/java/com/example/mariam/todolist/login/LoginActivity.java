package com.example.mariam.todolist.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mariam.todolist.R;
import com.example.mariam.todolist.register.RegistrationActivty;
import com.example.mariam.todolist.todo_list.TodoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    @BindView(R.id.etEmail_login_Activity)
    EditText etEmail;
    @BindView(R.id.etPassword_login_Activity)
    EditText etPassword;
    String email, password;
    LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.button_login)
    void onLoginButtonClick() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        mPresenter.onSignInClicked(email,password);
    }

    @OnClick(R.id.button_register)
    void onRegisterClick() {
       mPresenter.onSignUpClicked();
    }


    @Override
    public void navigateToTodoActivity() {
        Intent intent = new Intent(LoginActivity.this, TodoActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivty.class);
        startActivity(intent);
    }

    @Override
    public void showErrorMsg(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
