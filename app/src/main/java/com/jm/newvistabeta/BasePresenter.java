package com.jm.newvistabeta;

/**
 * Created by Johnny on 1/18/2018.
 */

public abstract class BasePresenter {

    private LoginView loginView;

    public LoginView getLoginView() {
        return loginView;
    }

    public void attachView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void detachView(LoginModel loginModel) {
        this.loginView = null;
        loginModel.cancel();
    }

}
