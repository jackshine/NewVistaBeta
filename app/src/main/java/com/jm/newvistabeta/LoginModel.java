package com.jm.newvistabeta;

import android.util.Log;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginModel extends BaseModel {
    private static final String URL_LOGIN = "http://192.168.123.217:8080/servlet.customer.LogIn";
    private MyOkHttp myOkHttp;

    public LoginModel(MyOkHttp myOkHttp) {
        this.myOkHttp = myOkHttp;
    }

    public void login(String email, String password, final LoginListener loginListener) {
        final HashMap params = new HashMap();
        params.put("email", email);
        params.put("password", password);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myOkHttp.post().url(URL_LOGIN).params(params).tag(this).enqueue(new JsonResponseHandler() {
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
        }).start();
    }

    @Override
    public void cancel() {
        Log.v("cancel", "cancel");
        myOkHttp.cancel(this);
    }
}
