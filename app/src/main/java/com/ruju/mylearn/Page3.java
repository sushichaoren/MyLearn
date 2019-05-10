package com.ruju.mylearn;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class Page3 extends Activity {

    //public TextView countdown = findViewById(R.id.countdown);
    //private TestHandlder mHandler = new TestHandlder();
    private TextView countdown;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        countdown = findViewById(R.id.countdown);
        Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what ) {
                    case 8888:
                        int value = (int) msg.obj;

                        countdown.setText(String.valueOf(value));

                    msg = Message.obtain();
                    msg.arg1 = 0;
                    msg.arg2 = 1;
                    msg.what = 8888;
                    msg.obj = value - 1;

                    if (value > 0) {
                        sendMessageDelayed(msg, 1000);
                    }
                        break;
                }
            }
        };

        Message message;
        message = mHandler.obtainMessage();
        message.arg1 = 0;
        message.arg2 = 1;
        message.what = 8888;
        message.obj = 10;

        mHandler.sendMessageDelayed(message, 1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                countdown.setText("多线程成功");
            }
        }).start();

    }

//    public class TestHandlder extends Handler {
//
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what ) {
//                case 8888:
//                int value = (int) msg.obj;
//
//                countdown.setText(String.valueOf(value));
//
//                msg = Message.obtain();
//                msg.arg1 = 0;
//                msg.arg2 = 1;
//                msg.what = 8888;
//                msg.obj = value - 1;
//
//                if (value > 0) {
//                    sendMessageDelayed(msg, 1000);
//                }
//                break;
//            }
//        }
//    }
}