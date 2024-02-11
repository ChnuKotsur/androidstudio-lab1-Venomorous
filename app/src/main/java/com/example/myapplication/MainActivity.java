package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.drawable.GradientDrawable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.main_layout);

        // Create a GradientDrawable with the desired colors and positions
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.BOTTOM_TOP,
                new int[]{
                        0xFF0F0A6A,
                        0xFF51194C,
                        0xFFA72D2D,
                        0xFFCA8080,
                        0xFFFFFFFF
                });

        constraintLayout.setBackground(gradientDrawable);
    }
}