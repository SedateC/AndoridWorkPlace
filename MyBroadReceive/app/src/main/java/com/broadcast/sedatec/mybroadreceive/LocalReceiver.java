package com.broadcast.sedatec.mybroadreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "receiveLoaclBroadcast", Toast.LENGTH_SHORT).show();
    }
}
