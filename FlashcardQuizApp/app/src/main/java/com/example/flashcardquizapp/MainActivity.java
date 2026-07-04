package com.example.flashcardquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txtQuestion;
    TextView txtAnswer;
    TextView txtCounter;

    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtAnswer = findViewById(R.id.txtAnswer);
        txtCounter = findViewById(R.id.txtCounter);

        Button btnShow = findViewById(R.id.btnShowAnswer);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnPrevious = findViewById(R.id.btnPrevious);
        Button btnManage = findViewById(R.id.btnManage);

        displayCard();

        btnShow.setOnClickListener(v ->
                txtAnswer.setVisibility(View.VISIBLE));

        btnNext.setOnClickListener(v -> {

            if (FlashcardData.flashcards.isEmpty())
                return;

            currentIndex++;

            if (currentIndex >= FlashcardData.flashcards.size())
                currentIndex = 0;

            displayCard();
        });

        btnPrevious.setOnClickListener(v -> {

            if (FlashcardData.flashcards.isEmpty())
                return;

            currentIndex--;

            if (currentIndex < 0)
                currentIndex =
                        FlashcardData.flashcards.size() - 1;

            displayCard();
        });

        btnManage.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            ManageFlashcardsActivity.class
                    );

            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (currentIndex >= FlashcardData.flashcards.size()
                && !FlashcardData.flashcards.isEmpty()) {
            currentIndex = 0;
        }

        displayCard();
    }

    private void displayCard() {

        if (FlashcardData.flashcards.isEmpty()) {

            txtQuestion.setText(R.string.no_flashcards_available);
            txtAnswer.setText("");
            txtCounter.setText(R.string.counter_empty);

            return;
        }

        Flashcard card =
                FlashcardData.flashcards.get(currentIndex);

        txtQuestion.setText(card.getQuestion());

        txtAnswer.setText(card.getAnswer());

        txtAnswer.setVisibility(View.GONE);

        txtCounter.setText(
                String.format(
                        Locale.getDefault(),
                        "%d/%d",
                        currentIndex + 1,
                        FlashcardData.flashcards.size()
                )
        );
    }
}