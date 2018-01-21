package com.jm.newvistabeta.mvp.presenter;

import android.os.Looper;

import com.jm.newvistabeta.bean.UserEntity;
import com.jm.newvistabeta.mvp.view.LoginView;
import com.jm.newvistabeta.mvp.base.BasePresenter;
import com.jm.newvistabeta.mvp.model.LoginModel;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {
    private LoginModel loginModel;
    private LoginView loginView;
    private UserEntity userEntity;

    public LoginPresenter() {
        loginModel = new LoginModel();
        userEntity = new UserEntity();
        super.BasePresenter(loginModel);
    }

    public void login() {
        loginView = getView();
        userEntity.setEmail(loginView.getEmail());
        userEntity.setPassword(loginView.getPassword());

        this.loginModel.login(userEntity, loginView.getServerIp(), new LoginModel.LoginCallbackListener() {
            @Override
            public void onFinish(String responseMessage) {
                if (responseMessage.contains("success")) {
                    loginView.onLoginSuccess();
                } else {
                    loginView.onLoginFailure();
                }
                loginView.onLoginResultToast(responseMessage);
            }

            @Override
            public void onError(String errorMessage) {
                loginView.onLoginResultToast(errorMessage);
            }
        });
    }

}
