package com.perfence.sedatec.sharedperferences;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by SedateC on 2017/7/22.
 */

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver forceOfflineReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFF_LINE");
        forceOfflineReceiver = new ForceOfflineReceiver();
        registerReceiver(forceOfflineReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (forceOfflineReceiver!=null){
            unregisterReceiver(forceOfflineReceiver);
            forceOfflineReceiver=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builderDialog = new AlertDialog.Builder(context);
            builderDialog.setTitle("warning");
            builderDialog.setCancelable(false);
            builderDialog.setMessage("you are force to be offline .Please try to login again");
            builderDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finshAll();
                    Intent intent1 = new Intent(context,LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            builderDialog.show();
        }
    }
}
