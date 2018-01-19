package com.jm.newvistabeta.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jm.newvistabeta.R;
import com.jm.newvistabeta.base.BaseActivity;
import com.jm.newvistabeta.model.LoginModel;
import com.jm.newvistabeta.presenter.LoginPresenter;
import com.jm.newvistabeta.view.LoginView;
import com.tsy.sdk.myokhttp.MyOkHttp;

public class MainActivity extends BaseActivity<LoginModel, LoginView, LoginPresenter> implements LoginView {

    private EditText email;
    private EditText password;
    private MyOkHttp myOkHttp = new MyOkHttp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    public void clickLogin(View view) {
        getPresenter().login();
    }

    @Override
    public String getEmail() {
        return email.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
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
