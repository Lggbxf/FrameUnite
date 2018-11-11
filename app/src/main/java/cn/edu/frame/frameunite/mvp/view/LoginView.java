package cn.edu.frame.frameunite.mvp.view;

public interface LoginView extends BaseView{

    void loginSuccess();
    void loginFailed(String data);
}
