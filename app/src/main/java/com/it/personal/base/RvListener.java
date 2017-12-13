package com.it.personal.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tangzhuo on 2017/12/12.
 */

public interface RvListener {
    void onItemClick(RecyclerView.ViewHolder holder, View view, int pos);
}
