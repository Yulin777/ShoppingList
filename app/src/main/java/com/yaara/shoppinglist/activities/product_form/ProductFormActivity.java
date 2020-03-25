package com.yaara.shoppinglist.activities.product_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yaara.shoppinglist.R;

import static com.yaara.shoppinglist.myConstants.PRODUCTֹ_ADDED_RESULT_CODE;

interface IProductFormView {

    String getName();

    int getAmount();

    String getSize();

    String getComment();

    void onError();

    void finishWithSuccess();
}

public class ProductFormActivity extends AppCompatActivity implements IProductFormView {
    Presenter mPresenter;
    private EditText mName;
    private EditText mAmount;
    private EditText mSize;
    private EditText mComment;
    private Button mAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);
        mPresenter = new Presenter(this);
        findViews();
        setListeners();
        mPresenter.init();
    }

    private void setListeners() {
        mAddBtn.setOnClickListener(mPresenter);
    }

    private void findViews() {
        this.mName = findViewById(R.id.product_form_name);
        this.mAmount = findViewById(R.id.product_form_amount);
        this.mSize = findViewById(R.id.product_form_size);
        this.mComment = findViewById(R.id.product_form_comment);
        this.mAddBtn = findViewById(R.id.add_product_btn);
    }

    @Override
    public String getName() {
        return this.mName.getText().toString();
    }

    @Override
    public int getAmount() {
        return Integer.parseInt(this.mAmount.getText().toString());
    }

    @Override
    public String getSize() {
        return this.mSize.getText().toString();
    }

    @Override
    public String getComment() {
        return mComment.getText().toString();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Uh Oh... something happened :(", Toast.LENGTH_LONG).show();

    }

    @Override
    public void finishWithSuccess() {
        setResult(PRODUCTֹ_ADDED_RESULT_CODE);
        finish();
    }
}
