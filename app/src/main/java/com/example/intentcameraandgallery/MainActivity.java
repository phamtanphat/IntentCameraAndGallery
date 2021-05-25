package com.example.intentcameraandgallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button mBtnCamera,mBtnGallery;
    ImageView mImg;
    int REQUEST_CODE_CAMERA = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnCamera = findViewById(R.id.buttonCamera);
        mBtnGallery = findViewById(R.id.buttonGallery);
        mImg = findViewById(R.id.imageView);

        mBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Programmatically open permission specific
//                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                Uri uri = Uri.fromParts("package", getPackageName(), null);
//                intent.setData(uri);
//                startActivity(intent);
                // Kiểm tra quyền camera đã được Granted
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_CODE_CAMERA
                    );
                }
            }
        });
    }
}