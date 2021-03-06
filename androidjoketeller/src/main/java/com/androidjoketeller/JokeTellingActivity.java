package com.androidjoketeller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class JokeTellingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_telling);

        TextView jokeTextView = findViewById(R.id.joke_textView);

        String joke = getIntent().getStringExtra(getApplicationContext().getResources().getString(R.string.joke_string));

        jokeTextView.setText(joke);
    }
}
