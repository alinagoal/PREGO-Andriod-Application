package com.alinadangol.pre;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class third_semester extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_semester);
        String fileName="videothird";
        String filePlace="android.resource://"+getPackageName()+"/raw/"+ fileName;
        VideoView videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(filePlace));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        videoView.setMediaController(new MediaController(this));



        videoView.start();
    }

}


