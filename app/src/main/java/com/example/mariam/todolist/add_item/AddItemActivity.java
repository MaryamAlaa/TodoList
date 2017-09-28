package com.example.mariam.todolist.add_item;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.mariam.todolist.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddItemActivity extends AppCompatActivity implements AddItemContract.View{
    @BindView(R.id.title_add_item)
    EditText title_add_item;
    @BindView(R.id.desc_add_item)
    EditText desc_add_item;
    String title, description;
    AddItemContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);
        presenter = new AddItemPresenter(this);

    }

    @OnClick(R.id.button_add_item)
    void onClick() {
        title = title_add_item.getText().toString();
        description = desc_add_item.getText().toString();
        presenter.onAddItemButtonClicked(title, description);
    }

    @Override
    public void onAddItemFinished() {
        finish();
    }
}
