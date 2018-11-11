package cn.edu.frame.frameunite.mvp.presenter;

import cn.edu.frame.frameunite.mvp.view.BaseView;

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    public T mPresenterView;
    @Override
    public void attachView(T view) {
        this.mPresenterView = view;
    }

    @Override
    public void detachView() {
        this.mPresenterView = null;
    }
}
