package cn.edu.frame.frameunite.di.component;

import android.app.Activity;

import cn.edu.frame.frameunite.MainActivity;
import cn.edu.frame.frameunite.di.moudle.ActivityMoudle;
import cn.edu.frame.frameunite.di.scope.PerActivity;
import dagger.Component;

@PerActivity
@Component(modules = ActivityMoudle.class)
public interface ActivityComponent {

    //Activity getActivity();
    void inject(MainActivity activity);
}
