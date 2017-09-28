package com.example.mariam.todolist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mariam.todolist.callbacks.ItemSelectedIterface;
import com.example.mariam.todolist.R;
import com.example.mariam.todolist.data.TodoItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domtyyyyyy on 8/29/2017.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.todoItemHolder> {

    List<TodoItem> list;
    Context context;
    private final ItemSelectedIterface listener;

    public TodoListAdapter(Context context, ItemSelectedIterface itemSelectedIterface) {
        //  this.list = list;
        this.context = context;
        this.listener = itemSelectedIterface;
        list = new ArrayList<>();
    }

    public void setList(List<TodoItem> listTodoItem) {
        this.list = listTodoItem;
    }

    @Override
    public todoItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        TodoListAdapter.todoItemHolder holder = new todoItemHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(todoItemHolder holder, int position) {
        TodoItem item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDesc());
        holder.itemView.setOnClickListener(view -> {
//                Intent intent = new Intent(context, UsersListActivity.class);
//                intent.putExtra("Items", item);
//                context.startActivity(intent);
            listener.onItemSelected(item);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class todoItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc)
        TextView description;

        public todoItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
