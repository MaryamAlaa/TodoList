package com.example.mariam.todolist.user_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mariam.todolist.R;
import com.example.mariam.todolist.todo_list.TodoActivity;
import com.example.mariam.todolist.adapters.UserListAdapter;
import com.example.mariam.todolist.data.TodoItem;
import com.example.mariam.todolist.data.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersListActivity extends AppCompatActivity implements UserListContract.View{
    @BindView(R.id.recyclerViewUserList)
    RecyclerView recyclerView;
    UserListAdapter userListAdapter;
    LinearLayoutManager layoutManager;
    UserListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        presenter = new UserListPresenter(this);
        presenter.setUserList();
        TodoItem currentItem = (TodoItem) getIntent().getSerializableExtra("Items");//

        userListAdapter = new UserListAdapter(this, currentItem, user -> {
            presenter.onUserClicked(user);
        });

        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void show(List<User> user) {
        userListAdapter.setUserList(user);
        recyclerView.setAdapter(userListAdapter);
    }

    @Override
    public void navigateToTodoActivity(User user) {
        Intent intent = new Intent(UsersListActivity.this, TodoActivity.class);
        intent.putExtra(getString(R.string.userEmail), user.getEmail());
        setResult(RESULT_OK, intent);
        finish();
    }
}
