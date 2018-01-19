package com.jm.newvistabeta.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jm.newvistabeta.R;
import com.jm.newvistabeta.ui.base.BaseActivity;
import com.jm.newvistabeta.mvp.model.LoginModel;
import com.jm.newvistabeta.mvp.presenter.LoginPresenter;
import com.jm.newvistabeta.mvp.view.LoginView;
import com.tsy.sdk.myokhttp.MyOkHttp;

public class LoginActivity extends BaseActivity<LoginModel, LoginView, LoginPresenter> implements LoginView {
    private EditText email;
    private EditText password;
    private Button submit;
    private MyOkHttp myOkHttp = new MyOkHttp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
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
    public void onLoginSuccess() {
        submit.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoginFailure() {
        submit.setVisibility(View.VISIBLE);
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
