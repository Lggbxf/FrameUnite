package cn.edu.frame.frameunite.di.moudle;

import android.app.Activity;

import cn.edu.frame.frameunite.R;
import cn.edu.frame.frameunite.mvp.presenter.LoginPresenter;
import cn.edu.frame.frameunite.mvp.presenter.LoginPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityMoudle {
    private Activity mActivity;

    public ActivityMoudle(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    public Activity getActivity(){
        return mActivity;
    }

    @Provides
    public LoginPresenter getLoginPresenter(){
        return new LoginPresenterImpl();
    }
}
