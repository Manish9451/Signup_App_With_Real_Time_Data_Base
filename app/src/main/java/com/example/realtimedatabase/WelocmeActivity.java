package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WelocmeActivity extends AppCompatActivity {

     ImageView imageView,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welocme);
        imageView=findViewById(R.id.googleimg);
        imageView2=findViewById(R.id.youtubeImg);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google="https://www.google.com";
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(google));
                startActivity(intent);
                finish();


            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String youtube="https://www.youtube.com";
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(youtube));
                startActivity(intent);
                finish();

            }
        });
    }
}