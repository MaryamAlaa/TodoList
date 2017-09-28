package com.example.mariam.todolist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mariam.todolist.R;
import com.example.mariam.todolist.callbacks.UserSelectedIterface;
import com.example.mariam.todolist.data.TodoItem;
import com.example.mariam.todolist.data.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Domtyyyyyy on 8/29/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.userListHolder> {

    private final UserSelectedIterface listener;
    private List<User> list;
     Context context;
      TodoItem item;



    public UserListAdapter(Context context,TodoItem item, UserSelectedIterface listener) {
        this.listener = listener;
        this.list = new ArrayList<>();
        this.context = context;
        this.item = item;
    }
  public  void setUserList(List<User> listUser) {
        this.list = listUser;
    }
    @Override
    public userListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        UserListAdapter.userListHolder holder = new userListHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(userListHolder holder, int position) {
        User user = list.get(position);
        holder.user.setText(user.getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserSelected(user);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class userListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user)
        TextView user;

        public userListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
