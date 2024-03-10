package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String[] items = {"Saint Martin", "Mongolia", "Estonian Navy", "Seychelles", "Switzerland"};
    // References to views
    private TextView countryNameTextView;
    private TextView hymnTextView;
    private TextView hymnTextTextView;
    private ImageView flagImageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendToSecondActivityButton = findViewById(R.id.send_to_second_activity_button);
        Button shareButton = findViewById(R.id.share_button);

        countryNameTextView = findViewById(R.id.countryNameTextView);
        hymnTextTextView = findViewById(R.id.hymnTextTextView); //Text of the hymn
        hymnTextView = findViewById(R.id.hymnTextView); // Title of the hymn
        flagImageView = findViewById(R.id.imageView);

        Spinner spinner = findViewById(R.id.spinner); // Correct way to find a Spinner in your layout
        ArrayAdapter<String> adapter = new CustomSpinnerAdapter(this, R.layout.spinner_item_layout_closed, Arrays.asList(items));
        spinner.setAdapter(adapter);

        final ConstraintLayout constraintLayout = findViewById(R.id.main_layout);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateUIBasedOnSelectedItem(position, constraintLayout);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
//
    }
    private void updateUIBasedOnSelectedItem(int selectedItemPosition, ConstraintLayout constraintLayout) {
        // Update TextViews and ImageView based on the selected item
        switch (selectedItemPosition) {
            case 0:
                countryNameTextView.setText(R.string.saint_martin);
                flagImageView.setImageResource(R.drawable.flag_of_saint_martin);
                hymnTextView.setText(R.string.hymn_of_saint_martin);
                hymnTextTextView.setText(R.string.st_martin_hymn);
                constraintLayout.setBackgroundResource(R.drawable.gradient_st_martin);
                break;
            case 1:
                countryNameTextView.setText(R.string.mongolia);
                flagImageView.setImageResource(R.drawable.flag_of_mongolia);
                hymnTextView.setText(R.string.hymn_of_mongolia);
                hymnTextTextView.setText(R.string.mongolia_hymn);
                constraintLayout.setBackgroundResource(R.drawable.gradient_mongolia);
                break;
            case 2:
                countryNameTextView.setText(R.string.estonian_navy);
                flagImageView.setImageResource(R.drawable.naval_jack_of_estonia);
                hymnTextView.setText(R.string.hymn_of_estonian_navy);
                hymnTextTextView.setText(R.string.estonian_navy_hymn);
                constraintLayout.setBackgroundResource(R.drawable.gradient_estonian_navy);

                break;
            case 3:
                countryNameTextView.setText(R.string.seychelles);
                flagImageView.setImageResource(R.drawable.flag_of_seychelles);
                hymnTextView.setText(R.string.hymn_of_seychelles);
                hymnTextTextView.setText(R.string.seychelles_hymn);
                constraintLayout.setBackgroundResource(R.drawable.gradient_seychelles);
                break;
            case 4:
                countryNameTextView.setText(R.string.switzerland);
                flagImageView.setImageResource(R.drawable.flag_of_switzerland);
                hymnTextView.setText(R.string.hymn_of_switzerland);
                hymnTextTextView.setText(R.string.switzerland_hymn);
                constraintLayout.setBackgroundResource(R.drawable.gradient_switzerland);
                break;
        }
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        startActivity(intent);
    }
}