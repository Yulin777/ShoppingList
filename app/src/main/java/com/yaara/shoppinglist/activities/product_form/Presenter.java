package com.yaara.shoppinglist.activities.product_form;

import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yaara.shoppinglist.R;
import com.yaara.shoppinglist.entities.Product;

/**
 * Created by Yulin. I on 26,March,2020
 */
public class Presenter implements View.OnClickListener {
    private final IProductFormView mView;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("productList");

    public Presenter(IProductFormView productFormView) {
        this.mView = productFormView;
    }

    public void init() {
        setAddBtn();
    }

    private void setAddBtn() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_product_btn:
                addProduct();
                break;
        }
    }

    private void addProduct() {
        Product product = new Product(
                mView.getName(),
                mView.getAmount(),
                mView.getSize(),
                mView.getComment()
        );
        myRef.child(mView.getName())
                .setValue(product)
                .addOnSuccessListener(aVoid -> {
                    mView.finishWithSuccess();
                })
                .addOnFailureListener(e -> {
                    mView.onError();
                });
    }
}
