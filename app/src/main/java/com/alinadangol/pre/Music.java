package com.alinadangol.pre;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Music extends AppCompatActivity {
    MediaPlayer mySong;
    MediaPlayer mySong1;
    MediaPlayer mySong2;
    MediaPlayer mySong3;
    MediaPlayer mySong4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        mySong=MediaPlayer.create(Music.this,R.raw.prettybaby);
        mySong1=MediaPlayer.create(Music.this,R.raw.crazylove);
        mySong2=MediaPlayer.create(Music.this,R.raw.my_sunshine);
        mySong3=MediaPlayer.create(Music.this,R.raw.maa);
        mySong4=MediaPlayer.create(Music.this,R.raw.lorilori);




    }


    public void playIT(View v){
        mySong.start();
    }
    public void playIT1(View v){
        mySong1.start();
    }
    public void playIT2(View v){
        mySong2.start();
    }
    public void playIT3(View v){
        mySong3.start();
    }
    public void playIT4(View v){
        mySong4.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
        mySong1.release();
        mySong2.release();
        mySong3.release();
        mySong4.release();

    }
}