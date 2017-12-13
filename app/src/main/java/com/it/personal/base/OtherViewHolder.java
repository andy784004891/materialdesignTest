package com.it.personal.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;


/**
 * Created by tangzhuo on 2017/12/12.
 */

public abstract class OtherViewHolder<T> extends RecyclerView.ViewHolder {
    private SparseArray<View> mSpArray;
    private View mConvertView;
    private Context mContext;
    protected RvListener mListener;


    public OtherViewHolder(Context context, View itemView, final RvListener listener) {
        super(itemView);
        mConvertView = itemView;
        mContext = context;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    //holder可能有问题
                    listener.onItemClick(OtherViewHolder.this, v, getAdapterPosition());
                }
            }
        });

    }

    /**
     * 通过viewId获取控件
     */
    public <T extends View> T getView(int viewId) {
        View view = mSpArray.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mSpArray.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    protected abstract void bindView(OtherViewHolder holder, T t, int pos);
}
