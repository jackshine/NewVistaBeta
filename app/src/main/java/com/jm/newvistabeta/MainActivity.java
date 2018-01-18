package com.jm.newvistabeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements LoginView {
    private Button button;
    MyOkHttp myOkHttp = new MyOkHttp();
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLogin(View view) {
        LoginPresenter loginPresenter = new LoginPresenter(myOkHttp);
        loginPresenter.attachView(this);
        loginPresenter.login("johnnysviva@gmail.com", "123456");
    }

    @Override
    public void onLoginResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.loginPresenter != null) {
            loginPresenter.detachView(loginPresenter.getLoginModel());
        }
    }
}
