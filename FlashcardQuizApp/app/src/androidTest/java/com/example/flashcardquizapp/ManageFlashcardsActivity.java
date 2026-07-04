package com.example.flashcardquizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ManageFlashcardsActivity
        extends AppCompatActivity {

    EditText etQuestion;
    EditText etAnswer;

    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_manage_flashcards
        );

        etQuestion = findViewById(R.id.etQuestion);
        etAnswer = findViewById(R.id.etAnswer);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnBack = findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(v -> {

            String q =
                    etQuestion.getText().toString().trim();

            String a =
                    etAnswer.getText().toString().trim();

            if (q.isEmpty() || a.isEmpty()) {

                Toast.makeText(
                        this,
                        "Enter Question & Answer",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            FlashcardData.flashcards.add(
                    new Flashcard(q, a)
            );

            etQuestion.setText("");
            etAnswer.setText("");

            Toast.makeText(
                    this,
                    "Flashcard Added",
                    Toast.LENGTH_SHORT
            ).show();
        });

        btnEdit.setOnClickListener(v -> {

            if (FlashcardData.flashcards.isEmpty())
                return;

            String q =
                    etQuestion.getText().toString();

            String a =
                    etAnswer.getText().toString();

            FlashcardData.flashcards
                    .get(currentIndex)
                    .setQuestion(q);

            FlashcardData.flashcards
                    .get(currentIndex)
                    .setAnswer(a);

            Toast.makeText(
                    this,
                    "Flashcard Updated",
                    Toast.LENGTH_SHORT
            ).show();
        });

        btnDelete.setOnClickListener(v -> {

            if (FlashcardData.flashcards.isEmpty())
                return;

            FlashcardData.flashcards.remove(
                    currentIndex
            );

            Toast.makeText(
                    this,
                    "Flashcard Deleted",
                    Toast.LENGTH_SHORT
            ).show();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}