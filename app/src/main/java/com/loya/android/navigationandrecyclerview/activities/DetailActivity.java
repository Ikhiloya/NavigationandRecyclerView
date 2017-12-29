package com.loya.android.navigationandrecyclerview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.loya.android.navigationandrecyclerview.R;

public class DetailActivity extends AppCompatActivity {

    private String alphabet, word;
    private TextView alphabetTextView, wordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //init views
        alphabetTextView = (TextView) findViewById(R.id.detail_alphabet_text);
        wordTextView = (TextView) findViewById(R.id.detail_word_text);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(MainActivity.ALPHABET_TEXT) && intent.hasExtra(MainActivity.WORD_TEXT)) {
                alphabet = intent.getStringExtra(MainActivity.ALPHABET_TEXT);
                word = intent.getStringExtra(MainActivity.WORD_TEXT);

                alphabetTextView.setText(alphabet);
                wordTextView.setText(word);

            }
        }
    }
}
