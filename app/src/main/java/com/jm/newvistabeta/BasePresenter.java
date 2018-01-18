package com.jm.newvistabeta;

/**
 * Created by Johnny on 1/18/2018.
 */

public abstract class BasePresenter<V extends BaseView> {

    private V view;

    public V getView() {
        return view;
    }

    public void attachView(V loginView) {
        this.view = loginView;
    }

    public void detachView(LoginModel loginModel) {
        this.view = null;
        loginModel.cancel();
    }

}
