/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.it.personal.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.it.personal.R;
import com.it.personal.base.BaseActivity;
import com.it.personal.util.LogUtil;
import com.it.personal.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheeseDetailActivity extends BaseActivity {

    public static final String EXTRA_NAME = "cheese_name";

    @BindView(R.id.toolbar_d)
    Toolbar toolbar;
    @BindView(R.id.fa_btn_detail)
    FloatingActionButton faBtnDetail;
    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //显示箭头

        collapsingToolbar.setTitle(cheeseName);

        Glide.with(this).load(R.drawable.ic_1).centerCrop().into(backdrop);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //暂不需要,通过清单文件已经实现该功能
//        if (item.getItemId() == android.R.id.home){
//            finish();
//        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.toolbar_d, R.id.fa_btn_detail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                LogUtil.d("andy--toolbar");
                break;
            case R.id.fa_btn_detail:
                ToastUtil.show("floatactionbtn");
                break;
        }
    }
}
