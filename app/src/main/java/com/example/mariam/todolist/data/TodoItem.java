package com.example.mariam.todolist.data;

import java.io.Serializable;

/**
 * Created by Domtyyyyyy on 8/29/2017.
 */

public class TodoItem implements Serializable {
    String title, desc, itemId;

    public TodoItem() {
    }

    public TodoItem(String title, String desc, String uid) {
        this.title = title;
        this.desc = desc;
        this.itemId = uid;
    }


    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
