package com.yaara.shoppinglist.activities.author;

import android.view.View;
import android.view.View.OnClickListener;

import com.yaara.shoppinglist.R;

/**
 * Created by Yulin. I on 25,March,2020
 */
public class Presenter implements OnClickListener {
    private final IAuthorView mView;

    Presenter(IAuthorView authorView) {
        this.mView = authorView;
    }

    void init() {
        setAuthorImage();
        setSubject();
        setAuthorName();
        setAuthorId();
        setYear();
    }

    private void setAuthorImage() {
        mView.updateAuthorImage(R.drawable.author_image);
    }

    private void setYear() {
        mView.updateYear("תש\"פ");
    }

    private void setAuthorId() {
        mView.updateAuthorId("3155787390");
    }

    private void setAuthorName() {
        mView.updateAuthorName("יערה פולקן");
    }

    private void setSubject() {
        mView.updateSubject("תיאום קניות בסופר");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.author_image_container:
            case R.id.project_subject_container:
            case R.id.project_author_name_container:
            case R.id.project_author_id_container:
            case R.id.project_year_container:
                //nothing
                break;
            case R.id.activity_container:
                mView.openProductListActivity();
                break;
        }
    }

}
