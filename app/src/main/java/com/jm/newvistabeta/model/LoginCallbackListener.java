package com.jm.newvistabeta.model;

import org.json.JSONObject;

/**
 * Created by Johnny on 1/18/2018.
 */

public interface LoginCallbackListener {

    public void onFinish(String message);

    public void onError(String message);

}
