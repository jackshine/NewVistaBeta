package com.jm.newvistabeta.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.jm.newvistabeta.util.ApplicationUtil;

public class LoginActivity extends BaseActivity<LoginModel, LoginView, LoginPresenter> implements LoginView {
    private EditText email;
    private EditText password;
    private EditText serverIp;
    private CheckBox saveUser;
    private Button logIn;
    private Button signUp;
    private TextView loginStatus;
    private TextView findPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialView();
        onNotifyPresenterToAutofill();
        Log.v("LoginActivity", (getPresenter().getView() == null) + "");
    }

    private void initialView() {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        serverIp = (EditText) findViewById(R.id.serverIp);
        saveUser = (CheckBox) findViewById(R.id.saveUser);
        logIn = (Button) findViewById(R.id.logIn);
        signUp = (Button) findViewById(R.id.signUp);
        loginStatus = (TextView) findViewById(R.id.signUpStatus);
        findPassword = (TextView) findViewById(R.id.findPassword);
    }

    public void clickLogin(View view) {
        getPresenter().login();
    }

    public void clickSignUp(View view) {
        // Todo: Jump tp sign up activity.
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void clickFindPassword(View view) {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT);
    }

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
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
    public String getServerIp() {
        return serverIp.getText().toString().trim();
    }

    @Override
    public void onLoginResultToast(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ApplicationUtil.getContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        loginStatus.setText("Login success.");
    }

    @Override
    public void onLoginFailure() {
        loginStatus.setText("Login fail.");
    }

    @Override
    public boolean onSaveUserChecked() {
        return saveUser.isChecked();
    }

    @Override
    public void onNotifyPresenterToAutofill() {
        getPresenter().autofill();
    }

    @Override
    public void onAutofillUserInfo(String email, String password) {
        this.email.setText(email);
        this.password.setText(password);
        saveUser.setChecked(true);
    }
}
