package cn.edu.frame.frameunite.mvp.presenter;

import java.util.Map;

import cn.edu.frame.frameunite.mvp.model.User;
import cn.edu.frame.frameunite.mvp.view.LoginView;

public interface LoginPresenter extends BasePresenter<LoginView> {
    void login(Map<String,String> map);
}
