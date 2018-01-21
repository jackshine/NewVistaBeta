package com.jm.newvistabeta.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Johnny on 1/21/2018.
 */

public class ApplicationUtil extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
