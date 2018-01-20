package com.jm.newvistabeta.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jm.newvistabeta.R;
import com.jm.newvistabeta.ui.base.BaseActivity;
import com.jm.newvistabeta.mvp.model.LoginModel;
import com.jm.newvistabeta.mvp.presenter.LoginPresenter;
import com.jm.newvistabeta.mvp.view.LoginView;
import com.tsy.sdk.myokhttp.MyOkHttp;

import org.w3c.dom.Text;

public class LoginActivity extends BaseActivity<LoginModel, LoginView, LoginPresenter> implements LoginView {
    private EditText email;
    private EditText password;
    private EditText serverIp;
    private CheckBox saveAccount;
    private Button logIn;
    private Button signUp;
    private TextView loginStatus;
    private TextView findPassword;

    private MyOkHttp myOkHttp = new MyOkHttp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialView();
    }

    private void initialView() {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        serverIp = (EditText) findViewById(R.id.serverIp);
        saveAccount = (CheckBox) findViewById(R.id.saveAccount);
        logIn = (Button) findViewById(R.id.logIn);
        signUp = (Button) findViewById(R.id.signUp);
        loginStatus = (TextView) findViewById(R.id.loginStatus);
        findPassword = (TextView) findViewById(R.id.findPassword);
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
    }

    @Override
    public void onLoginFailure() {
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
