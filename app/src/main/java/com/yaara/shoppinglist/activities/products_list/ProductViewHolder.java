package com.yaara.shoppinglist.activities.products_list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yaara.shoppinglist.R;

/**
 * Created by Yulin. I on 25,March,2020
 */
class ProductViewHolder extends RecyclerView.ViewHolder {
    private TextView name, amount, size;
    private TextView comment;

    ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(View itemView) {
        this.name = itemView.findViewById(R.id.product_item_name);
        this.amount = itemView.findViewById(R.id.product_item_amount);
        this.size = itemView.findViewById(R.id.product_item_size);
        this.comment = itemView.findViewById(R.id.product_item_comment);
    }

    void setName(String name) {
        this.name.setText(name);
    }

    void setAmount(int amount) {
        this.amount.setText(String.valueOf(amount));
    }

    void setSize(String size) {
        this.size.setText(size);
    }

    void setComment(String comment) {
        this.comment.setText(comment);
    }
}
