package com.jm.newvistabeta.mvp.model;

import android.util.Log;

import com.jm.newvistabeta.bean.UserEntity;
import com.jm.newvistabeta.mvp.base.BaseModel;
import com.jm.newvistabeta.util.NetworkUtil;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Johnny on 1/18/2018.
 */

public class LoginModel extends BaseModel {
    //    private static final String URL_LOGIN = "http://192.168.123.217:8080/servlet.customer.LogIn";
    private MyOkHttp myOkHttp;

    public LoginModel() {
        this.myOkHttp = NetworkUtil.myOkHttp;
    }

    public void login(UserEntity userEntity, String serverIp, final LoginCallbackListener loginCallbackListener) {
        final HashMap params = new HashMap();
        params.put("email", userEntity.getEmail());
        params.put("password", userEntity.getPassword());
        final String url = "http://" + serverIp + ":8080/servlet.customer.LogIn";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myOkHttp.post().url(url).params(params).tag(this).enqueue(new JsonResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, JSONObject response) {
                        loginCallbackListener.onFinish(response.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        loginCallbackListener.onError(error_msg);
                    }
                });
            }
        }).start();
    }

    @Override
    public void cancel() {
        Log.v("cancel()", getClass() + ": Cancel login.");
        myOkHttp.cancel(this);
    }

    public interface LoginCallbackListener {
        void onFinish(String responseMessage);

        void onError(String errorMessage);
    }
}
