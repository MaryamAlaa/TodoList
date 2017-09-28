package com.example.mariam.todolist.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mariam.todolist.add_item.AddItemActivity;
import com.example.mariam.todolist.R;
import com.example.mariam.todolist.user_list.UsersListActivity;
import com.example.mariam.todolist.adapters.TodoListAdapter;
import com.example.mariam.todolist.data.TodoItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TodoActivity extends AppCompatActivity implements TodoListContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    TodoListAdapter todoListAdapter;
    LinearLayoutManager layoutManager;
    int REQUEST_CODE = 3;
    TodoListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        ButterKnife.bind(this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        presenter = new TodoListPresenter(this);
        presenter.listReady();

        fab.setOnClickListener(view -> {
            presenter.onFabClicked();
        });

        todoListAdapter = new TodoListAdapter(TodoActivity.this, item -> {
            presenter.itemSelected(item);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String emailUser = data.getStringExtra(getString(R.string.userEmail));
            presenter.onUserSelected(emailUser);
        }
    }

    @Override
    public void navigateToAddItem() {
        Intent intent = new Intent(TodoActivity.this, AddItemActivity.class);
        startActivity(intent);
    }

    @Override
    public void show(List<TodoItem> todoItems) {
        todoListAdapter.setList(todoItems);
        recyclerView.setAdapter(todoListAdapter);
    }

    @Override
    public void navigateTOUserList() {
        Intent intent = new Intent(TodoActivity.this, UsersListActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

}