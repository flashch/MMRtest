package com.china.one.mmrtest.mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.china.one.commom.base.BaseFragment;
import com.china.one.commom.di.component.AppComponent;
import com.china.one.commom.utils.UiUtils;
import com.china.one.mmrtest.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Test1Fragment extends BaseFragment {


    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.bt_go_setting_module)
    Button btGoSettingModule;
    @BindView(R.id.bt_go_login_module)
    Button btGoLoginModule;

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test1, null);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }

    @OnClick({R.id.tv_test, R.id.bt_go_login_module, R.id.bt_go_setting_module})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                break;
            case R.id.bt_go_login_module:
                UiUtils.makeText(getContext(), "登录");
                ARouter.getInstance().build("/login/loginActivity").navigation();
                break;
            case R.id.bt_go_setting_module:
                UiUtils.makeText(getContext(), "设置");
                ARouter.getInstance().build("/setting/settingActivity").navigation();
                break;
        }
    }
}
