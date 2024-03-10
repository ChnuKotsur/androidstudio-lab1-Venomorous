package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;


public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        TextView receiveTextView = findViewById(R.id.receiveTextView);
        TextView receiveHymnTextView = findViewById(R.id.receiveHymnTextView);

        // Retrieve the selected hymn from the Intent
        String selectedHymn = getIntent().getStringExtra("selectedHymnText");
        String selectedHymnText = getIntent().getStringExtra("selectedHymn");

        // Display the selected hymn in the TextView
        receiveTextView.setText(selectedHymn);
        receiveHymnTextView.setText(selectedHymnText);
    }

}