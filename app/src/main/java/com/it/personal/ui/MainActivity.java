package com.it.personal.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.it.personal.R;
import com.it.personal.base.BaseActivity;
import com.it.personal.util.LogUtil;
import com.it.personal.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = "andy";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.fab)
    FloatingActionButton mFloatActBtn;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.nav_view_left)
    NavigationView mLeftContent;
    @BindView(R.id.rl_right)
    RelativeLayout mRightContent;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("actionbar 标题");

        setupDrawerContent();
        initViewPager();
        //必须在viewpager初始完成后执行
        mTabLayout.setupWithViewPager(mViewpager);

    }

    private void initViewPager() {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new PListFragment(), "widget");
        adapter.addFragment(new PListFragment(), "自定义view");
        adapter.addFragment(new PListFragment(), "开源框架");
        mViewpager.setAdapter(adapter);
    }

    private void setupDrawerContent() {
        mLeftContent.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //根据item响应不同的动作
                String title = item.getTitle().toString();
                ToastUtil.show(title);
                mDrawerLayout.closeDrawers();
                item.setChecked(true);
                return true;
            }
        });
    }

    @OnClick({R.id.toolbar, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                break;
            case R.id.fab:
                //snackbar的具体用法
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("按钮", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtil.show("snackbar被点击了");
                            }
                        }).show();
                break;
        }
    }

    //每次点击menu键都会重新调用, 可以用来更新menu对应的ui
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        LogUtil.d(TAG, "onPrepareOptionsMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    //只会调用一次
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_night_mode_system:
                ToastUtil.show("mode_system");
                break;
            case R.id.menu_night_mode_day:
                ToastUtil.show("mode_day");
                break;
            case R.id.menu_night_mode_night:
                ToastUtil.show("mode_night");
                break;
            case R.id.menu_night_mode_auto:
                ToastUtil.show("mode_auto");
                break;
            case R.id.t1:
                ToastUtil.show("t1");
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
