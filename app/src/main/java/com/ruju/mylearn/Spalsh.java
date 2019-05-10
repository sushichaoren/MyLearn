package com.ruju.mylearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.IDN;

public class Spalsh extends Activity {

//    public static final String TITLE = "title";
//    public static final String USER = "user";
//    public static final int REQUEST_CODE = 9999;
//    public static final String ON_ACTIVITY = "onActivity";
//    Userinfo  userinfo= new Userinfo("jason",25);
//    private  static final String TAG = Spalsh.class.getSimpleName();
//    private final TextView textView = findViewById(R.id.textsplash);

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        final String text = textView.getText().toString();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //跳转到MainActicity
                Intent intent = new Intent(Spalsh.this,MainActivity.class);
                //intent.putExtra(TITLE,text);
                //intent.putExtra(USER,userinfo);
                startActivity(intent);
                //startActivityForResult(intent, REQUEST_CODE);
            }
        },1000);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.i(TAG,"requestcode:"+requestCode+"resultCode:"+resultCode);
//    }
}
