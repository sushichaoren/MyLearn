package com.ruju.mylearn;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class Page5 extends Activity {

    private MyBroadcastReceiver myBroadcastReceiver=new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page5);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ruju.mylearn.broadcast");
        registerReceiver(myBroadcastReceiver, intentFilter);


        findViewById(R.id.brButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.ruju.mylearn.broadcast");
                intent.putExtra("tobr","发射成功");
                sendBroadcast(intent);

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReceiver);
    }
}
