package com.padcmyanmar.sfc.mvp.presenters;

import com.padcmyanmar.sfc.data.models.NewsModel;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.views.NewsDetailsView;

public class NewsDetailsPresenter extends BasePresenter<NewsDetailsView> {

    public NewsDetailsPresenter(NewsDetailsView view) {
        super(view);
    }


    public void onFinishUIComponent(String newsId) {
        NewsVO news = NewsModel.getInstance().getNewsById(newsId);
        mView.displayNewsDetails(news);
    }
}
