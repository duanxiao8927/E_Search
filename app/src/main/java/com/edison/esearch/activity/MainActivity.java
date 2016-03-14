package com.edison.esearch.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edison.eaction.ActionCallbackListener;
import com.edison.esearch.R;
import com.edison.model.PhoneInfo;

/**
 * Created by xiaotufei on 16/3/6.
 */
public class MainActivity extends EBaseActivity {

    private TextView tv;
    private Button btn ;
    private EditText numberEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    public void initView(){
        tv = (TextView) findViewById(R.id.text_weather);
        btn = (Button) findViewById(R.id.button);
        numberEdit = (EditText) findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getinfo();
            }
        });
    }

    public void getinfo(){


        String number = numberEdit.getText().toString().trim();

        if (null!=number&&number.length()>0) {
            appAction.phoneInfo(number, new ActionCallbackListener<PhoneInfo>() {
                @Override
                public void onSuccess(PhoneInfo data) {
                    Log.i(this.getClass().getName(), "" + data.getProvince());
                    tv.setText("运营商:" + data.getSupplier() + "\n归属地:" + data.getCity() + "\n");
                }

                @Override
                public void onFailure(String errorEvent, String message) {

                }
            });
        }else{
            Toast.makeText(getApplicationContext(),"请输入",Toast.LENGTH_LONG).show();
        }
    }



}
