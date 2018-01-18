package com.jm.newvistabeta;

import com.tsy.sdk.myokhttp.MyOkHttp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginPresenter {
    private LoginModel loginModel;
    private LoginView loginView;
    private MyOkHttp myOkHttp;

    public LoginPresenter(LoginView loginView, MyOkHttp myOkHttp) {
        this.loginView = loginView;
        loginModel = new LoginModel();
        this.myOkHttp = myOkHttp;
    }

    public void login(String email, String password) {
        this.loginModel.login(email, password, myOkHttp, new LoginListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                if (loginView != null) {
                    try {
                        loginView.onLoginResult(jsonObject.getString("loginStatus"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
