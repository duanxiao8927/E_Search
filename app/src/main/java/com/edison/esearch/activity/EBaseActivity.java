package com.edison.esearch.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.edison.eaction.AppAction;
import com.edison.esearch.EApplication;

/**
 * Created by xiaotufei on 16/3/6.
 */
public class EBaseActivity extends FragmentActivity {
    // 上下文实例
    public Context context;
    // 应用全局的实例
    public EApplication application;
    // 核心层的Action实例
    public AppAction appAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        application = (EApplication) this.getApplication();
        appAction = application.getAppAction();
    }
}
