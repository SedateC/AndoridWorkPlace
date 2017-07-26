package com.perfence.sedatec.sharedperferences;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.broadcast.sedatec.filepersistencetest.R;

public class FinishAcivity extends BaseActivity {
        private Button buttonOffLine ;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_activity);
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
