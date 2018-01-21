package com.jm.newvistabeta.mvp.view;

import com.jm.newvistabeta.mvp.base.BaseView;

/**
 * Created by Johnny on 1/21/2018.
 */

public interface SignUpView extends BaseView {
    String getUsername();

    String getEmail();

    String getPassword();

    String getPassword2();

    String getServerIp();

    void onPasswordNotMatched();

    void onSignUpResultToast(String responseMessage);

    void onSignUpSuccess();

    void onSignUpFailure();
}
