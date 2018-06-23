package com.padcmyanmar.sfc.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.delegates.NewsItemDelegate;

import butterknife.BindView;
import butterknife.OnClick;

public class NewNewsViewHolder extends BaseViewHolder<NewsVO> {

    @BindView(R.id.iv_news_image)
    ImageView ivNewsImage;

    @BindView(R.id.iv_news_publisher)
    ImageView ivLogo;

    @BindView(R.id.tv_news_publisher)
    TextView tvNewsPublisher;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.tv_news_date)
    TextView tvNewsDate;

    @BindView(R.id.tv_news_id)
    TextView tvNewsId;

    private NewsItemDelegate mNewsItemDelegate;

    private NewsVO news;

    public NewNewsViewHolder(View itemView, NewsItemDelegate newsItemDelegate) {
        super(itemView);
        mNewsItemDelegate = newsItemDelegate;
    }

    @Override
    public void setData(NewsVO data) {
        news = data;
        tvNewsId.setText(data.getNewsId());
        tvNewsBrief.setText(data.getDetails());
        tvNewsDate.setText(data.getPostedDate());
        tvNewsPublisher.setText(data.getPublication().getTitle());
        if (!data.getImages().isEmpty()) {
            Glide.with(ivNewsImage.getContext())
                    .load(data.getImages().get(0))
                    .into(ivNewsImage);
        } else {
            ivNewsImage.setVisibility(View.GONE);
        }
        Glide.with(ivLogo.getContext())
                .load(data.getPublication().getLogo())
                .into(ivLogo);
    }

    @Override
    public void onClick(View v) {
        mNewsItemDelegate.onTapNews(news);
    }
}
