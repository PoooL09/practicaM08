package com.pallares.pol.practicam08.playvideo;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.pallares.pol.practicam08.R;

public class PlayVideoActivity extends AppCompatActivity {

    WebView webView;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_video);

        videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+ R.raw.video_apex));
        MediaController mediaController = new MediaController(this);

        videoView.setMediaController(mediaController);
        videoView.start();
        back();
    }
    private void back(){
        getSupportActionBar().setTitle("PLAY VIDEO");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
