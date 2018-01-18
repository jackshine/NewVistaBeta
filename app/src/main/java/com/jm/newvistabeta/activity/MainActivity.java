package com.jm.newvistabeta.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jm.newvistabeta.R;
import com.jm.newvistabeta.base.BaseActivity;
import com.jm.newvistabeta.model.LoginModel;
import com.jm.newvistabeta.presenter.LoginPresenter;
import com.jm.newvistabeta.view.LoginView;
import com.tsy.sdk.myokhttp.MyOkHttp;

public class MainActivity extends BaseActivity<LoginModel, LoginView, LoginPresenter> implements LoginView {
    MyOkHttp myOkHttp = new MyOkHttp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLogin(View view) {
        getPresenter().login("johnnysviva@gmail.com0", "123456");
    }

    @Override
    public void onLoginResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(myOkHttp);
    }
}
