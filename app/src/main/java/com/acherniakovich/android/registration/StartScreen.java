package com.acherniakovich.android.registration;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.acherniakovich.android.R;

public class StartScreen extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        video = (VideoView)findViewById(R.id.video);
        downloadVideo();
    }

    private void downloadVideo() {
        //String videoSource ="/sdcard/Movies/cat.3gp";

        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.start_one));

        video.setOnPreparedListener(PreparedListener);
        MediaController MC = new MediaController(this);
        MC.setVisibility(View.INVISIBLE);
        video.setMediaController(MC);
        video.requestFocus();
        //video.start(); // начинаем воспроизведение автоматически
    }

    MediaPlayer.OnPreparedListener PreparedListener = new MediaPlayer.OnPreparedListener(){

        @Override
        public void onPrepared(MediaPlayer m) {
            try {
                if (m.isPlaying()) {
                    m.stop();
                    m.release();
                    m = new MediaPlayer();
                }
                m.setVolume(0f, 0f);
                m.setLooping(true);
                m.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
