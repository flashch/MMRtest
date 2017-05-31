package com.china.one.mmrtest.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.china.one.commom.base.BaseActivity;
import com.china.one.commom.di.component.AppComponent;
import com.china.one.mmrtest.R;
import com.china.one.mmrtest.mvp.model.entity.TabEntity;
import com.china.one.mmrtest.mvp.ui.fragment.Test1Fragment;
import com.china.one.mmrtest.mvp.ui.fragment.Test2Fragment;
import com.china.one.mmrtest.mvp.ui.fragment.Test3Fragment;
import com.china.one.mmrtest.mvp.ui.fragment.Test4Fragment;
import com.china.one.mmrtest.mvp.ui.fragment.VideoFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.ctl_bottom_title)
    CommonTabLayout ctlBottomTitle;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> fragments=new ArrayList<>();
    private String[] mTitles = {"直播", "测试", "视频", "地图", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initFragments();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i],mIconSelectIds[i], mIconUnselectIds[i]));
        }
        ctlBottomTitle.setTabData(mTabEntities,MainActivity.this,R.id.main_container,fragments);
    }

    private void initFragments() {
        fragments.add(new VideoFragment());
        fragments.add(new Test1Fragment());
        fragments.add(new Test2Fragment());
        fragments.add(new Test3Fragment());
        fragments.add(new Test4Fragment());
    }
}
