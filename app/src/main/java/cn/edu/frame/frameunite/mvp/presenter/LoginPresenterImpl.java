package cn.edu.frame.frameunite.mvp.presenter;

import android.util.Log;

import java.util.Map;

import javax.inject.Inject;

import cn.edu.frame.frameunite.ApiService;
import cn.edu.frame.frameunite.BaseResult;
import cn.edu.frame.frameunite.mvp.view.LoginView;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter{

    private static final String base_url = "http://video.enjoynut.cn/";

    @Inject
    public LoginPresenterImpl() {

    }

    @Override
    public void login(Map<String,String> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        api.getLogin(map)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Subscriber<BaseResult>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i("MainActivity", "凉凉" + e.toString());

                    }
                    @Override
                    public void onNext(BaseResult baseResult) {
                        Log.i("MainActivity", baseResult.getErrno() + " " + baseResult.getData());
                        if(baseResult.getErrno()==0){
                            mPresenterView.loginSuccess();
                        }else {
                            mPresenterView.loginFailed(baseResult.getData());
                        }

                    }
                });
//        if (user.getUsername().equals("abc")&&user.getPassword().equals("123")){
//            mPresenterView.loginSuccess();
//        }else {
//            mPresenterView.loginFailed();
//        }

    }
}
