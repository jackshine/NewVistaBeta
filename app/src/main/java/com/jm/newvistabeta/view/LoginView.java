package com.jm.newvistabeta.view;

import com.jm.newvistabeta.base.BaseView;

/**
 * Created by Johnny on 1/18/2018.
 */

// Callback interface of view layer.
public interface LoginView extends BaseView {

    String getEmail();

    String getPassword();

    void onLoginResult(String result);

}
