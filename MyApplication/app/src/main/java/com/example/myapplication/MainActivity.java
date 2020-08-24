package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.mgImageView);

//        Picasso.get().load("http://10.0.192.104/vms/download/object/thumb/72/72.jpg").into(imageView);
        Log.d(this.getClass().getSimpleName(),"....................." + imageView);
        Glide.with(this)
                .load("http://10.0.192.104/vms/download/object/thumb/72/72.jpg")
                .error(R.drawable.ic_launcher_background)
                .into(imageView);

        Log.d(this.getClass().getSimpleName(),"....................." + imageView);
    }
}
