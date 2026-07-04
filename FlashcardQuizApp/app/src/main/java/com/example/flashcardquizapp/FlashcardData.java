package com.example.flashcardquizapp;

import java.util.ArrayList;

public class FlashcardData {

    public static ArrayList<Flashcard> flashcards = new ArrayList<>();

    static {

        flashcards.add(
                new Flashcard(
                        "What is Java?",
                        "Java is a programming language."
                )
        );

        flashcards.add(
                new Flashcard(
                        "What is Android?",
                        "Android is a mobile operating system."
                )
        );

        flashcards.add(
                new Flashcard(
                        "What is OOP?",
                        "Object Oriented Programming."
                )
        );
    }
}