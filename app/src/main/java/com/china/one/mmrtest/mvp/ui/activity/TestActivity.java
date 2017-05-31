package com.china.one.mmrtest.mvp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.china.one.commom.utils.UiUtils;
import com.china.one.mmrtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends Activity {

    @BindView(R.id.bt_test)
    Button btTest;
    @BindView(R.id.bt_setting)
    Button btSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_test, R.id.bt_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_test:
                UiUtils.makeText(TestActivity.this,"测试");
                ARouter.getInstance().build("/test/activity").navigation();
                break;
            case R.id.bt_setting:
                UiUtils.makeText(TestActivity.this,"设置");
                ARouter.getInstance().build("/module/setting").navigation();
                break;
        }
    }
}
