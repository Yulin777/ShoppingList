package com.yaara.shoppinglist.activities.products_list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yaara.shoppinglist.R;
import com.yaara.shoppinglist.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Yulin. I on 25,March,2020
 */
class ProductsListAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<Product> productsList = new ArrayList<>();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("productList");


    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            List<Product> newProductsList = new ArrayList<>();
            dataSnapshot.getChildren().iterator().forEachRemaining(dataSnapshot1 -> {
                Product p = dataSnapshot1.getValue(Product.class);
                newProductsList.add(p);
            });
            productsList = newProductsList;
            notifyDataSetChanged();
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            //handle failure here
        }
    };

    public ProductsListAdapter() {
        myRef.addValueEventListener(postListener);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        ProductViewHolder holder = new ProductViewHolder(itemView);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product p = productsList.get(position);

        holder.setName(p.name);
        holder.setAmount(p.amount);
        holder.setSize(p.size);
        holder.setComment(p.comment);
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
