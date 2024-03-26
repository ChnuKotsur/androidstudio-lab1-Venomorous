package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String[] items = {"Saint Martin", "Mongolia", "Estonian Navy", "Seychelles", "Switzerland"};
    // References to views
    private TextView countryNameTextView;
    private TextView hymnTextView;
    private TextView hymnTextTextView;
    private ImageView flagImageView;
    private int seconds = 0;
    private boolean running;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button sendToSecondActivityButton = findViewById(R.id.send_to_second_activity_button);
//        Button shareButton = findViewById(R.id.share_button);

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

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }

        runTimer();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
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
        String selectedHymn = hymnTextView.getText().toString();
        String hymnText = hymnTextTextView.getText().toString();

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("selectedHymn", selectedHymn);
        intent.putExtra("selectedHymnText", hymnText);
        startActivity(intent);
    }

    public void onSendMessageOtherApps(View view) {
        String selectedHymn = hymnTextView.getText().toString();
        String hymnText = hymnTextTextView.getText().toString();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, selectedHymn + "\n\n" + hymnText);
        intent.setType("text/plain");
        startActivity(intent);
    }

    public void onClickStart(View view) {
        running = true;
    }
    //Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view) {
        running = false;
    }
    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}