package com.ruju.mylearn;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Page4 extends Activity implements View.OnClickListener {

    private Button mPauseButton;
    private MusicService mMusicService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //mMusicService = (MusicService) service;
            MusicService.LocalBinder localBinder = (MusicService.LocalBinder) service;
            mMusicService = localBinder.getService();
            if (mMusicService != null) {
                int progress = mMusicService.getMusicPlayProgress();
                //Log.i("获取数值", String.valueOf(progress));
                mPauseButton.setText(String.valueOf(progress));
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4);
        Button mStaertButton = findViewById(R.id.btstart);
        Button mStopButton = findViewById(R.id.btstop);
        mPauseButton = findViewById(R.id.btpause);

        mStaertButton.setOnClickListener(this);
        mStopButton.setOnClickListener(this);
        mPauseButton.setOnClickListener(Page4.this);
        Log.i("获取数值", String.valueOf(5));
//        if (mMusicService != null) {
//            int progress = mMusicService.getMusicPlayProgress();
//            Log.i("获取数值", String.valueOf(progress));
//        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btstart:
                Intent intent1 = new Intent(this,MusicService.class);
                //intent1.putExtra("state",stateswitch);

                //startService(intent1);
                bindService(intent1, mServiceConnection, BIND_AUTO_CREATE);

                break;
            case R.id.btstop:
                if (mMusicService != null){
                    unbindService(mServiceConnection);
                    //stopService(new Intent(this,MusicService.class));
                    mMusicService =null;
                }

                //stopService(new Intent(this,MusicService.class));
                break;
//            case R.id.btpause:
//                Intent intent0 = new Intent(this,MusicService.class);
//                intent0.putExtra("state",0);
//                startService(intent0);
//                break;
        }
    }
}
