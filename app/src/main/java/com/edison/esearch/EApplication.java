package com.edison.esearch;

import android.app.Application;

import com.edison.eaction.AppAction;
import com.edison.eaction.AppActionImpl;

/**
 * Created by xiaotufei on 16/3/6.
 */
public class EApplication extends Application{
    private AppAction appAction;
    private String a = null;
    @Override
    public void onCreate() {
        super.onCreate();
        appAction = new AppActionImpl(this);
    }



    public AppAction getAppAction() {
        return appAction;
    }
}
