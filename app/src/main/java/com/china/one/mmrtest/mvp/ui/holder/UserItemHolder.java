package com.china.one.mmrtest.mvp.ui.holder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.china.one.commom.base.App;
import com.china.one.commom.base.BaseHolder;
import com.china.one.commom.di.component.AppComponent;
import com.china.one.commom.widget.imageloader.ImageLoader;
import com.china.one.commom.widget.imageloader.glide.GlideImageConfig;
import com.china.one.mmrtest.R;
import com.china.one.mmrtest.mvp.model.entity.User;

import butterknife.BindView;
import io.reactivex.Observable;


public class UserItemHolder extends BaseHolder<User> {

    @Nullable
    @BindView(R.id.iv_avatar)
    ImageView mAvater;
    @Nullable
    @BindView(R.id.tv_name)
    TextView mName;
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架

    public UserItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到Application的地方,拿到AppComponent,从而得到用Dagger管理的单例对象
        mAppComponent = ((App) itemView.getContext().getApplicationContext()).getAppComponent();
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(User data, int position) {
        Observable.just(data.getLogin())
                .subscribe(s -> mName.setText(s));

        mImageLoader.loadImage(mAppComponent.appManager().getCurrentActivity() == null
                        ? mAppComponent.Application() : mAppComponent.appManager().getCurrentActivity(),
                GlideImageConfig
                        .builder()
                        .url(data.getAvatarUrl())
                        .imageView(mAvater)
                        .build());
    }


    @Override
    protected void onRelease() {
        mImageLoader.clear(mAppComponent.Application(), GlideImageConfig.builder()
                .imageViews(mAvater)
                .build());
    }
}
