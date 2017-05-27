package com.china.one.mmrtest.di.component;


import com.china.one.commom.di.component.AppComponent;
import com.china.one.commom.di.scope.ActivityScope;
import com.china.one.mmrtest.di.module.UserModule;
import com.china.one.mmrtest.mvp.ui.activity.UserActivity;

import dagger.Component;


@ActivityScope
@Component(modules = UserModule.class,dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity activity);
}
