package com.ruju.mylearn;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

public class MusicService extends Service {

    private String TAG="服务测试";
    private MediaPlayer player;
    private IBinder mIBinder=new LocalBinder();


    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this,R.raw.sense_of_unity);
        Log.i(TAG, "开始: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.i(TAG, "onStartCommand: ");
        if (intent!=null){

            if (player.isPlaying()) {
                player.pause();
            } else {
                player.start();
            }
        }
        Log.i("播放状态", player.isPlaying()?"在播放":"没在播放");
        //player.start();

        return super.onStartCommand(intent, flags, startId);
    }



    @Override
    public IBinder onBind(Intent intent) {
        int state = intent.getIntExtra("state", -1);
//        if (intent != null) {
//
//            switch (state) {
//                case 1:
//                    player.start();
//                    break;
//                case 0:
//                    player.pause();
//                    break;
//            }
//        }
//        Log.i("服务数字", String.valueOf(state));

        player.start();
        return mIBinder;
    }

    public class LocalBinder extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }

    public int getMusicPlayProgress(){
        return 18;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Log.i(TAG, "销毁: ");
    }
}
