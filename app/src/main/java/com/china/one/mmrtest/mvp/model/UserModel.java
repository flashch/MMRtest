package com.china.one.mmrtest.mvp.model;

import com.china.one.commom.di.scope.ActivityScope;
import com.china.one.commom.integration.IRepositoryManager;
import com.china.one.commom.mvp.BaseModel;
import com.china.one.mmrtest.mvp.contract.UserContract;
import com.china.one.mmrtest.mvp.model.api.cache.CommonCache;
import com.china.one.mmrtest.mvp.model.api.service.UserService;
import com.china.one.mmrtest.mvp.model.entity.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;

@ActivityScope
public class UserModel extends BaseModel implements UserContract.Model {
    public static final int USERS_PER_PAGE = 10;

    @Inject
    public UserModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<User>> getUsers(int lastIdQueried, boolean update) {
        Observable<List<User>> users = mRepositoryManager.obtainRetrofitService(UserService.class)
                .getUsers(lastIdQueried, USERS_PER_PAGE);
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return mRepositoryManager.obtainCacheService(CommonCache.class)
                .getUsers(users
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update))
                .flatMap(new Function<Reply<List<User>>, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(@NonNull Reply<List<User>> listReply) throws Exception {
                        return Observable.just(listReply.getData());
                    }
                });
    }

}
