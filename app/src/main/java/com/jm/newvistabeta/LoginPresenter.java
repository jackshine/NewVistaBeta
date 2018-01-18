package com.jm.newvistabeta;

import com.tsy.sdk.myokhttp.MyOkHttp;

import org.json.JSONException;
import org.json.JSONObject;

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
        this.loginModel.login(email, password, new LoginListener() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                if (getView() != null) {
                    getView().onLoginResult(jsonObject.toString());
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

}
