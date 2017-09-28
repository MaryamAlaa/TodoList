package com.example.mariam.todolist.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mariam.todolist.R;
import com.example.mariam.todolist.todo_list.TodoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivty extends AppCompatActivity implements RegistrationContract.View {
    @BindView(R.id.etEmail_Registration_Activity)
    EditText etEmail;
    @BindView(R.id.etPassword_Registration_Activity)
    EditText etPassword;

    String email, password;
    RegistrationPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activty);
        ButterKnife.bind(this);
        mPresenter = new RegistrationPresenter(this);
    }


    @OnClick(R.id.button_register)
    void onClick() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        mPresenter.onSignUpClicked(email, password);
    }

    @Override
    public void navigateToTodoActivity() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegistrationActivty.this, TodoActivity.class);
        startActivity(intent);
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();

    }

}


//        database = FirebaseDatabase.getInstance();
//        auth = FirebaseAuth.getInstance();
//        User user = new User(email, auth.getCurrentUser().getUid());
//        RxFirebaseDatabase.setValue(database.getReference().child("Users").child(auth.getCurrentUser().getUid()), user).subscribe();