package com.broadcast.sedatec.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by SedateC on 2017/7/19.
 */

public class MainActivity extends BaseActivity {
    private Button buttonOffLine ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOffLine = (Button) findViewById(R.id.button_OFFLINE);
        buttonOffLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFF_LINE");
                sendBroadcast(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
