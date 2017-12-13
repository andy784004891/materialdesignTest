package com.it.personal.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.it.personal.R;
import com.it.personal.base.BaseFragment;
import com.it.personal.bean.ItemBean;
import com.it.personal.bean.ListData;
import com.it.personal.recyclerview.CommonAdapter;
import com.it.personal.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tangzhuo on 2017/12/12.
 */

public class PListFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private List<ItemBean> mList = new ArrayList<>();
    private CommonAdapter<ItemBean> mAdapter;

    @Override
    protected void initView(View rootView) {
        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity.getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

    }

    @Override
    protected void initData() {
        int length = ListData.datas.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            mList.add(new ItemBean(ListData.datas[i], 1));
        }
        mAdapter = new CommonAdapter<ItemBean>(getContext(), R.layout.item_normal, mList) {
            @Override
            protected void convert(ViewHolder holder, final ItemBean itemBean, final int position) {
                holder.setText(R.id.txt_name, itemBean.title);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        click(itemBean, position);

                    }
                });
            }
        };
        mRecyclerView.setAdapter(mAdapter);
    }

    private void click(ItemBean itemBean, int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(mActivity, CheeseDetailActivity.class);
                intent.putExtra(CheeseDetailActivity.EXTRA_NAME, itemBean.title);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(mActivity, ToolBarActivity.class);
                startActivity(intent);
                break;
            case 2:

                break;
            default:
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }


}
