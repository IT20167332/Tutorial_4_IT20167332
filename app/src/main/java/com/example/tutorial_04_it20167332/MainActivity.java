package com.example.tutorial_04_it20167332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.imageView);
        Button photoButton = (Button) this.findViewById(R.id.button_01);

        photoButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }


}