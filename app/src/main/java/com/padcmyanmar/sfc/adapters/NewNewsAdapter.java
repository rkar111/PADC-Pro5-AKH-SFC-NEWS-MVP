package com.padcmyanmar.sfc.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.delegates.NewsItemDelegate;
import com.padcmyanmar.sfc.viewholders.NewNewsViewHolder;

public class NewNewsAdapter extends BaseRecyclerAdapter<NewNewsViewHolder, NewsVO> {

    private NewsItemDelegate mNewsItemDelegate;

    public NewNewsAdapter(Context context, NewsItemDelegate newsItemDelegate) {
        super(context);
        mNewsItemDelegate = newsItemDelegate;
    }

    @NonNull
    @Override
    public NewNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newNewsItemView = mLayoutInflator.inflate(R.layout.view_item_new_news, parent, false);
        return new NewNewsViewHolder(newNewsItemView, mNewsItemDelegate);
    }
}
