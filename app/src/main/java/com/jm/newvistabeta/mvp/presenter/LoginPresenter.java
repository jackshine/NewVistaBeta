package com.jm.newvistabeta.mvp.presenter;

import com.jm.newvistabeta.bean.UserEntity;
import com.jm.newvistabeta.mvp.view.LoginView;
import com.jm.newvistabeta.mvp.base.BasePresenter;
import com.jm.newvistabeta.mvp.model.LoginModel;
import com.tsy.sdk.myokhttp.MyOkHttp;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {
    private LoginModel loginModel;
    private UserEntity userEntity;

    public LoginPresenter(MyOkHttp myOkHttp) {
        loginModel = new LoginModel(myOkHttp);
        userEntity = new UserEntity();
        super.BasePresenter(loginModel);
    }

    public void login() {
        userEntity.setEmail(getView().getEmail());
        userEntity.setPassword(getView().getPassword());

        this.loginModel.login(userEntity, new LoginModel.LoginCallbackListener() {
            @Override
            public void onFinish(String message) {
                if (getView() != null) {
                    if (message.contains("succeed")) {
                        getView().onLoginSuccess();
                    } else {
                        getView().onLoginFailure();
                    }
                    getView().onLoginResult(message);
                }
            }

            @Override
            public void onError(String message) {
                if (getView() != null) {
                    getView().onLoginResult(message);
                }
            }
        });
    }

}
