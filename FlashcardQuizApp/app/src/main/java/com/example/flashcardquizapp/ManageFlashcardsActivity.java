package com.example.flashcardquizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ManageFlashcardsActivity extends AppCompatActivity {

    private EditText etQuestion;
    private EditText etAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_flashcards);

        etQuestion = findViewById(R.id.etQuestion);
        etAnswer = findViewById(R.id.etAnswer);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnBack = findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(v -> {

            String question = etQuestion.getText().toString().trim();
            String answer = etAnswer.getText().toString().trim();

            if (question.isEmpty() || answer.isEmpty()) {
                Toast.makeText(this,
                        "Enter Question and Answer",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            FlashcardData.flashcards.add(
                    new Flashcard(question, answer));

            etQuestion.setText("");
            etAnswer.setText("");

            Toast.makeText(this,
                    "Flashcard Added",
                    Toast.LENGTH_SHORT).show();
        });

        btnEdit.setOnClickListener(v -> {

            if (FlashcardData.flashcards.isEmpty()) {
                Toast.makeText(this,
                        "No Flashcards Available",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String question = etQuestion.getText().toString().trim();
            String answer = etAnswer.getText().toString().trim();

            FlashcardData.flashcards.get(0)
                    .setQuestion(question);

            FlashcardData.flashcards.get(0)
                    .setAnswer(answer);

            Toast.makeText(this,
                    "First Flashcard Updated",
                    Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(v -> {

            if (FlashcardData.flashcards.isEmpty()) {
                Toast.makeText(this,
                        "No Flashcards Available",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            FlashcardData.flashcards.remove(0);

            Toast.makeText(this,
                    "First Flashcard Deleted",
                    Toast.LENGTH_SHORT).show();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}