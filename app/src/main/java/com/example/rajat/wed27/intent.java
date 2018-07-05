package com.example.rajat.wed27;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class intent extends AppCompatActivity {

    Button alarm,timer,camera,gallery,capture;
    static Uri mlocationforphotos;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        alarm = findViewById(R.id.alarm);
        timer = findViewById(R.id.timer);
        camera = findViewById(R.id.camera);
        gallery = findViewById(R.id.gallery);
        capture = findViewById(R.id.capture);
        image = findViewById(R.id.image);


        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE,"Wake up man")
                        .putExtra(AlarmClock.EXTRA_HOUR,01)
                        .putExtra(AlarmClock.EXTRA_MINUTES,02);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }

            }
        });

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE,"Its time")
                        .putExtra(AlarmClock.EXTRA_LENGTH,60)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI,true);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                    Toast.makeText(intent.this, "Timer is set for 60 Seconds", Toast.LENGTH_SHORT).show();
                }

            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),2);
            }
        });

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(intent,1);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK){
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(thumbnail);

        }

        if(requestCode==2 && resultCode==RESULT_OK){
            Bitmap thumbnail = null;
            try {
                thumbnail = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(),data.getData());
                image.setImageBitmap(thumbnail);
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setImageBitmap(thumbnail);

        }

    }
}
