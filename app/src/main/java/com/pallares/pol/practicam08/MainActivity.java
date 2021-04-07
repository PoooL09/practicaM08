package com.pallares.pol.practicam08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.pallares.pol.practicam08.mediarecorder.MediaRecorderActivity;
import com.pallares.pol.practicam08.playvideo.PlayVideoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_go_video);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayVideoActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn1 = (Button) findViewById(R.id.btn_go_grab);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MediaRecorderActivity.class);
                startActivityForResult(intent, 0);
            }
        });


    }
}