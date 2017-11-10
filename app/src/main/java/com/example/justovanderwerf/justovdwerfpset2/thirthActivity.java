package com.example.justovanderwerf.justovdwerfpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;


public class thirthActivity extends AppCompatActivity {

    Story story;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirth);

        String[] stories = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt",
                "madlib3_clothes.txt", "madlib4_dance.txt"};

        Random rnd = new Random();

        int n = rnd.nextInt(5);

        InputStream text = null;
        try {
            text = getAssets().open(stories[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        story = new Story(text);

        wordfiller();


    }

    public void wordfiller() {
        TextView textViewWTG = findViewById(R.id.textViewWTG);
        textViewWTG.setText("Fill in a " + story.getNextPlaceholder() + " only " + story.getPlaceholderRemainingCount() + " words to go!");

        EditText wordtypeph = findViewById(R.id.wordtypeph);
        wordtypeph.setText("");


    }

    public void buttonNWord(View view) {
        EditText wordtypeph = findViewById(R.id.wordtypeph);
        story.fillInPlaceholder(String.valueOf(wordtypeph.getText()));

        if (story.isFilledIn()) {
            Intent intent = new Intent(this, TextActivity.class);
            intent.putExtra("finalText", story.toString());
            startActivity(intent);
            finish();
        }

        wordfiller();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("turnover", story);

        EditText editText = (EditText) findViewById(R.id.wordtypeph);
        String EditTextValue = editText.getText().toString();
        outState.putString("currentText", EditTextValue);
    }

    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        story =(Story) inState.getSerializable("turnover");

        EditText editText = (EditText) findViewById(R.id.wordtypeph);
        String editTextRestored = inState.getString("currentText");
        editText.setText(editTextRestored);

        wordfiller();

    }
}

