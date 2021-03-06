package com.example.yf.creatorshirt.mvp.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yf.creatorshirt.R;
import com.example.yf.creatorshirt.mvp.model.BombStyleBean;
import com.example.yf.creatorshirt.mvp.ui.adapter.base.BaseAdapter;
import com.example.yf.creatorshirt.mvp.ui.adapter.viewholder.DesignerOrdersViewHolder;

/**
 * Created by yangfang on 2017/9/13.
 */

public class DesignerOrdersAdapter extends BaseAdapter<BombStyleBean, DesignerOrdersViewHolder> {

    public DesignerOrdersAdapter(Context context) {
        super(context);
    }

    @Override
    protected DesignerOrdersViewHolder createItemViewHolder(ViewGroup parent, int viewType) {
        return new DesignerOrdersViewHolder(parent, R.layout.item_designer_orders);
    }

    @Override
    protected void bindCustomViewHolder(DesignerOrdersViewHolder holder, final int position) {
        if (!TextUtils.isEmpty(mData.get(position).getFinishimage())) {
            holder.mDesignerName.setText(mData.get(position).getBaseName());
            holder.mDesignerPraise.setText(mData.get(position).getPraise() + "人赞");
            RequestOptions options = new RequestOptions();
            Glide.with(mContext).load(mData.get(position).getFinishimage()).apply(options).into(holder.mDesignerIv);
            holder.mLinearDesigner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(clickListener != null)
                    clickListener.onItemClick(null,0,mData.get(position));
                }
            });
        }
    }
}
