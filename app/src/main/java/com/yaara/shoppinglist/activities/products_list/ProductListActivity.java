package com.yaara.shoppinglist.activities.products_list;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yaara.shoppinglist.R;
import com.yaara.shoppinglist.activities.product_form.ProductFormActivity;

import static com.yaara.shoppinglist.myConstants.PRODUCT_FORM_REQUEST_CODE;
import static com.yaara.shoppinglist.myConstants.PRODUCTֹ_ADDED_RESULT_CODE;

interface IProductListView {

    RecyclerView getProductsRecyclerView();

    FloatingActionButton getAddProductFab();

    void openProductForm();
}

public class ProductListActivity extends AppCompatActivity implements IProductListView {
    Presenter mPresenter;
    private RecyclerView mProductsList;
    private FloatingActionButton mAddProductFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mPresenter = new Presenter(this);
        findViews();
        mPresenter.init();
    }

    private void findViews() {
        this.mProductsList = findViewById(R.id.products_recyclerview);
        this.mAddProductFab = findViewById(R.id.add_product_fab);
    }

    @Override
    public RecyclerView getProductsRecyclerView() {
        return this.mProductsList;
    }

    @Override
    public FloatingActionButton getAddProductFab() {
        return this.mAddProductFab;
    }

    @Override
    public void openProductForm() {
        Intent intent = new Intent(this, ProductFormActivity.class);
        startActivityForResult(intent, PRODUCT_FORM_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case PRODUCT_FORM_REQUEST_CODE:
                if (resultCode == PRODUCTֹ_ADDED_RESULT_CODE) {
                    mPresenter.onProductAdded();
                }
                break;
        }
    }
}
