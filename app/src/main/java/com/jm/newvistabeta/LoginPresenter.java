package com.jm.newvistabeta;

import com.tsy.sdk.myokhttp.MyOkHttp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginPresenter extends BasePresenter {

    private LoginModel loginModel;

    public LoginPresenter(MyOkHttp myOkHttp) {
        loginModel = new LoginModel(myOkHttp);
    }

    public void login(String email, String password) {
        this.loginModel.login(email, password, new LoginListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                if (getLoginView() != null) {
                    getLoginView().onLoginResult(jsonObject.toString());
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

}
