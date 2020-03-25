package com.yaara.shoppinglist.activities.author;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.yaara.shoppinglist.R;
import com.yaara.shoppinglist.activities.products_list.ProductListActivity;

import static com.yaara.shoppinglist.myConstants.PRODUCT_LIST_ACTIVITY_REQUEST_CODE;

interface IAuthorView {

    void updateYear(String s);

    void updateAuthorId(String s);

    void updateAuthorName(String s);

    void updateSubject(String s);

    void openProductListActivity();

    void updateAuthorImage(int authorImage);
}

public class AuthorActivity extends AppCompatActivity implements IAuthorView {
    Presenter mPresenter;

    private ConstraintLayout mContainer;
    private TextView mAuthorName;
    private TextView mSubjectName;
    private TextView mAuthorId;
    private TextView mAuthorYear;
    private ImageView mAuthorImage;

    private View mSubjectNameContainer;
    private View mAuthorNameContainer;
    private View mAuthorIdContainer;
    private View mAuthorYearContainer;
    private View mAuthorImageContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        mPresenter = new Presenter(this);
        findViews();
        setListeners();
        mPresenter.init();
    }

    private void findViews() {
        this.mContainer = findViewById(R.id.activity_container);
        this.mSubjectNameContainer = mContainer.findViewById(R.id.project_subject_container);
        this.mSubjectName = mSubjectNameContainer.findViewById(R.id.project_subject);
        this.mAuthorNameContainer = mContainer.findViewById(R.id.project_author_name_container);
        this.mAuthorName = mAuthorNameContainer.findViewById(R.id.project_author_name);
        this.mAuthorIdContainer = mContainer.findViewById(R.id.project_author_id_container);
        this.mAuthorId = mAuthorIdContainer.findViewById(R.id.project_author_id);
        this.mAuthorYearContainer = mContainer.findViewById(R.id.project_year_container);
        this.mAuthorYear = mAuthorYearContainer.findViewById(R.id.project_year);
        this.mAuthorImageContainer = mContainer.findViewById(R.id.author_image_container);
        this.mAuthorImage = mAuthorImageContainer.findViewById(R.id.author_image);
    }

    private void setListeners() {
        mContainer.setOnClickListener(mPresenter);
        mAuthorImageContainer.setOnClickListener(mPresenter);
        mSubjectNameContainer.setOnClickListener(mPresenter);
        mAuthorNameContainer.setOnClickListener(mPresenter);
        mAuthorIdContainer.setOnClickListener(mPresenter);
        mAuthorYearContainer.setOnClickListener(mPresenter);
    }

    @Override
    public void updateYear(String s) {
        mAuthorYear.setText(s);
    }

    @Override
    public void updateAuthorId(String s) {
        mAuthorId.setText(s);
    }

    @Override
    public void updateAuthorName(String s) {
        mAuthorName.setText(s);
    }

    @Override
    public void updateSubject(String s) {
        mSubjectName.setText(s);
    }

    @Override
    public void openProductListActivity() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivityForResult(intent, PRODUCT_LIST_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void updateAuthorImage(int authorImage) {
        mAuthorImage.setImageResource(authorImage);
    }
}
