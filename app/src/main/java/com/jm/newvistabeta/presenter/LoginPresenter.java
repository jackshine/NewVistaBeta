package com.jm.newvistabeta.presenter;

import com.jm.newvistabeta.view.LoginView;
import com.jm.newvistabeta.base.BasePresenter;
import com.jm.newvistabeta.model.LoginCallbackListener;
import com.jm.newvistabeta.model.LoginModel;
import com.tsy.sdk.myokhttp.MyOkHttp;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {

    private LoginModel loginModel;

    public LoginPresenter(MyOkHttp myOkHttp) {
        loginModel = new LoginModel(myOkHttp);
        super.BasePresenter(loginModel);

    }

    public void login(String email, String password) {
        this.loginModel.login(email, password, new LoginCallbackListener() {
            @Override
            public void onFinish(String message) {
                if (getView() != null) {
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
