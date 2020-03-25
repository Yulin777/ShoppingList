package com.yaara.shoppinglist.activities.products_list;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Yulin. I on 25,March,2020
 */
public class Presenter {
    private final IProductListView mView;
    private ProductsListAdapter productsListAdapter;

    public Presenter(IProductListView productListView) {
        this.mView = productListView;
    }

    public void init() {
        setProductsList();
        setAddProduct();
    }

    private void setAddProduct() {
        mView.getAddProductFab().setOnClickListener(v -> {
            mView.openProductForm();
        });
    }

    private void setProductsList() {
        RecyclerView productsRecyclerView = mView.getProductsRecyclerView();
        productsListAdapter = new ProductsListAdapter();
        productsRecyclerView.setAdapter(productsListAdapter);
    }

    void onProductAdded() {
        //nothing, there is a listener connected directly to firebase changes
    }
}
