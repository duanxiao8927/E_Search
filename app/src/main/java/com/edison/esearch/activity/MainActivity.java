package com.edison.esearch.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.edison.eaction.ActionCallbackListener;
import com.edison.esearch.R;
import com.edison.esearch.utils.ShareUtils;
import com.edison.model.PhoneInfo;

/**
 * Created by xiaotufei on 16/3/6.
 */
public class MainActivity extends EBaseActivity {


    private TextView tv;
    private Button btn;
    private String abc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    public void initView() {
        tv = (TextView) findViewById(R.id.text_weather);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getinfo();
                ShareUtils.share(MainActivity.this, "testshare", "https:" +
                        "//ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd" +
                        "_logo1_31bdc765.png", "https://www.baidu.com/", "分享测试内容");
            }
        });
    }


    public void getinfo() {

        this.appAction.phoneInfo("13681885767", new ActionCallbackListener<PhoneInfo>() {
            @Override
            public void onSuccess(PhoneInfo data) {
                Log.i("归属地", "qqqqq" + data.getProvince());
                tv.setText("AAA" + data.getProvince());


            }

            @Override
            public void onFailure(String errorEvent, String message) {

            }
        });

    }


}
