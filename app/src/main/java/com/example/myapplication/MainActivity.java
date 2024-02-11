package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.main_layout);

        // Create a GradientDrawable with the desired colors and positions
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{
                        0xFF0F0A6A,
                        0xFF2C0E5D,
                        0xFF440E5D,
                        0xFF39104C,
                        0xFF591542,
                        0xFF71183E,
                        0xFF8A1B34,
                        0xFF97212D,
                        0xFFB42121,
                        0xFFB42121,
                        0xFFB93131,
                        0xFFC04747,
                        0xFFCC6F6F,
                        0xFFFFFFFF
                });

        linearLayout.setBackground(gradientDrawable);
    }
}