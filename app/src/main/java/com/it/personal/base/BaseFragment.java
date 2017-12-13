package com.it.personal.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;

/**
 * Created by tangzhuo on 2017/12/12.
 */

public abstract class BaseFragment extends Fragment {

    private View mRootView;
    private Unbinder unbinder;   //用于解绑
    protected Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(getLayoutId(), container, false);
        //this不能用getactivity();
//        unbinder = ButterKnife.bind(this, mRootView);   暂不使用黄油刀
        initView(mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
//        unbinder.unbind(); //解绑
        super.onDestroyView();
    }

    protected abstract void initView(View rootView);

    protected abstract void initData();

    protected abstract int getLayoutId();
}
