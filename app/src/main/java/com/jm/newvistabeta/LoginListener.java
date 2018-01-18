package com.jm.newvistabeta;

import org.json.JSONObject;

/**
 * Created by Johnny on 1/18/2018.
 */

public interface LoginListener {
    public void onSuccess(JSONObject jsonObject);

    public void onFailure(String message);
}
