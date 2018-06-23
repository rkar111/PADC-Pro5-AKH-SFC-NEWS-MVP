package com.padcmyanmar.sfc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.adapters.NewNewsAdapter;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.presenters.NewsListPresenter;
import com.padcmyanmar.sfc.mvp.views.NewsListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewNewsListActivity extends BaseActivity implements NewsListView {

    @BindView(R.id.rv_new_news_list)
    RecyclerView rvNewNewsList;

    @BindView(R.id.new_toolbar)
    Toolbar newToolbar;

    private NewNewsAdapter mNewNewsAdapter;
    private NewsListPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);
        ButterKnife.bind(this, this);

        mPresenter = new NewsListPresenter(this);
        mPresenter.onCreate();
        mNewNewsAdapter = new NewNewsAdapter(getApplicationContext(), mPresenter);
        setSupportActionBar(newToolbar);

        rvNewNewsList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvNewNewsList.setAdapter(mNewNewsAdapter);

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
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
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
    public void displayNewsList(List<NewsVO> newsList) {
        mNewNewsAdapter.appendNewData(newsList);
    }

    @Override
    public void launchNewsDetailsActivity(String newsId) {
        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext(), newsId);
        startActivity(intent);
    }

    @Override
    public void displayErrorMsg(String errorMsg) {
    }
}
