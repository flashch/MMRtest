package com.china.one.mmrtest.mvp.ui.adapter;

import android.view.View;

import com.china.one.commom.base.BaseHolder;
import com.china.one.commom.base.DefaultAdapter;
import com.china.one.mmrtest.R;
import com.china.one.mmrtest.mvp.model.entity.User;
import com.china.one.mmrtest.mvp.ui.holder.UserItemHolder;

import java.util.List;


public class UserAdapter extends DefaultAdapter<User> {
    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<User> getHolder(View v, int viewType) {
        return new UserItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list;
    }
}
