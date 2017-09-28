package com.example.mariam.todolist.add_item;

/**
 * Created by Domtyyyyyy on 9/17/2017.
 */

class AddItemPresenter implements AddItemContract.Presenter {
    AddItemContract.View view;
    AddItemModel item;

    AddItemPresenter(AddItemContract.View view) {
        item = new AddItemModel();
        this.view = view;
    }

    @Override
    public void onAddItemButtonClicked(String title, String description) {
        item.addItem(title, description).subscribe(() -> {view.onAddItemFinished();}, Throwable::printStackTrace);
    }

}
