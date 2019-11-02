package com.example.tomandjerry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isTomVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView tomImageView = findViewById(R.id.tomImageView);

        //tomImageView.animate().rotation(360).setDuration(3000);
        //tomImageView.animate().scaleY(0.5f).scaleX(0.5f).rotation(3600).setDuration(3000);

        //tomImageView.animate().translationXBy(-100).translationYBy(-100).setDuration(3000);
    }

    public void eraseTom(View view) {

        if(isTomVisible) {
            ImageView tomImageView = findViewById(R.id.tomImageView);
            tomImageView.animate().alpha(0).rotation(tomImageView.getRotation() + 3600)
                    .scaleX(0)
                    .scaleY(0)
                    .setDuration(3000);

            ImageView jerryImageView = findViewById(R.id.jerryImageView);
            jerryImageView.animate().alpha(1).rotation(jerryImageView.getRotation() +  3600)
                    .scaleX(1)
                    .scaleY(1)
                    .setDuration(3000);

            isTomVisible = false;
        } else {
            ImageView tomImageView = findViewById(R.id.tomImageView);
            tomImageView.animate().alpha(1).rotation(tomImageView.getRotation() + 3600)
                    .scaleX(1)
                    .scaleY(1)
                    .setDuration(3000);

            ImageView jerryImageView = findViewById(R.id.jerryImageView);
            jerryImageView.animate().alpha(0).rotation(jerryImageView.getRotation() +  3600)
                    .scaleX(0)
                    .scaleY(0)
                    .setDuration(3000);

            isTomVisible = true;

        }
    }
}
