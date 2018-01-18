package com.jm.newvistabeta;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginModel {
    public static final String URL_LOGIN = "http://192.168.123.217:8080/servlet.customer.LogIn";

    public void login(String email, String password, final MyOkHttp myOkHttp, final LoginListener loginListener) {
        HashMap params = new HashMap();
        params.put("email", email);
        params.put("password", password);
        myOkHttp.post().url(URL_LOGIN).params(params).enqueue(new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {
                loginListener.onSuccess(response);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                loginListener.onFailure(error_msg);
            }
        });
    }
}
