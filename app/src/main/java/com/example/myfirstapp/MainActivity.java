package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static Random rand = new Random();
    private int secret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secret = rand.nextInt(100) + 1;
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Start another activity in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message = editText.getText().toString();
        int guess = Integer.parseInt(message);
        TextView textView = findViewById(R.id.Suggestions);

        if (guess < secret) {
            textView.setText("Guess Higher!");
        }
        else if (guess > secret) {
            textView.setText("Guess Lower!");
        }
        else {
            intent.putExtra(EXTRA_MESSAGE, "Congratulations!");
            startActivity(intent);
        }

    }
}