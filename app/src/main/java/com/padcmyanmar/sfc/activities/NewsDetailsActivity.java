package com.padcmyanmar.sfc.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.adapters.NewsImagesPagerAdapter;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.presenters.NewsDetailsPresenter;
import com.padcmyanmar.sfc.mvp.views.NewsDetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aung on 11/11/17.
 */

public class NewsDetailsActivity extends BaseActivity
        implements NewsDetailsView {

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    private NewsDetailsPresenter mPresenter;

    private static final String IE_NEWS_ID = "IE_NEWS_ID";

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    public static Intent newIntent(Context context, String newsId) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(IE_NEWS_ID, newsId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);
        mPresenter = new NewsDetailsPresenter(this);
        mPresenter.onCreate();

        NewsImagesPagerAdapter newsImagesPagerAdapter = new NewsImagesPagerAdapter(getApplicationContext());
        vpNewsDetailsImages.setAdapter(newsImagesPagerAdapter);

        String newsId = getIntent().getStringExtra(IE_NEWS_ID);
        mPresenter.onFinishUIComponent(newsId);
        //TODO get NewsVO by newsId.
        //TODO bind data to UI components.
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void displayNewsDetails(NewsVO news) {
        tvNewsDetails.setText(news.getDetails());
    }

    @Override
    public void displayErrorMsg(String errorMsg) {

    }
}
