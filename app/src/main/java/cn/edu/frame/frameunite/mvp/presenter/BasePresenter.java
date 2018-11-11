package cn.edu.frame.frameunite.mvp.presenter;



public interface BasePresenter<T> {
    void attachView(T view);
    void detachView();
}
