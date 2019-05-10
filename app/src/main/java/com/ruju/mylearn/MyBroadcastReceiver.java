package com.ruju.mylearn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //广播接收
        if (intent != null) {
            if (TextUtils.equals(intent.getAction(),"com.ruju.mylearn.broadcast")){
                String tobr=intent.getStringExtra("tobr");
                Toast.makeText(context,tobr,Toast.LENGTH_SHORT).show();
            }
        }
    }


}
