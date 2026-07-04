package com.example.randomquotegenerator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvQuote, tvAuthor;
    Button btnNewQuote;

    String[] quotes = {
            "The only true wisdom is in knowing you know nothing.",
            "Life is what happens when you're busy making other plans.",
            "The purpose of our lives is to be happy.",
            "You miss 100% of the shots you don't take.",
            "Good friends, good books, and a sleepy conscience: this is the ideal life.",
            "Life is really simple, but we insist on making it complicated.",
            "Do not dwell in the past, concentrate on the present moment.",
            "Turn your wounds into wisdom.",
            "Keep smiling, because life is a beautiful thing.",
            "Health is the greatest gift.",
            "The only way to do great work is to love what you do.",
            "Success is not final, failure is not fatal.",
            "Believe you can and you're halfway there.",
            "The future belongs to those who believe in their dreams.",
            "It always seems impossible until it's done.",
            "Don't watch the clock; keep going.",
            "The secret of getting ahead is getting started.",
            "It does not matter how slowly you go.",
            "Opportunities don't happen. You create them.",
            "Success usually comes to those who are too busy to be looking for it.",
            "I never dreamed about success, I worked for it.",
            "There are no secrets to success.",
            "Go confidently in the direction of your dreams.",
            "Where there is love there is life.",
            "Love all, trust a few, do wrong to none.",
            "Being deeply loved by someone gives you strength.",
            "Love is composed of a single soul inhabiting two bodies.",
            "The giving of love is an education in itself.",
            "Dream, dream, dream. Dreams transform into thoughts.",
            "Success is when your signature becomes an autograph.",
            "If you want to shine like a sun, first burn like a sun.",
            "Excellence is a continuous process and not an accident.",
            "Small aim is a crime; have great aim.",
            "Confidence and hard work are the best medicine.",
            "Man needs difficulties because they are necessary to enjoy success.",
            "You have to dream before your dreams can come true.",
            "Great dreams of great dreamers are always transcended.",
            "Thinking should become your capital asset.",
            "Learning gives creativity.",
            "Creativity leads to thinking.",
            "Thinking provides knowledge.",
            "Knowledge makes you great.",
            "All birds find shelter during a rain.",
            "Let us sacrifice our today so that our children can have a better tomorrow.",
            "Never stop fighting until you arrive at your destined place.",
            "Failure will never overtake me if my determination is strong enough.",
            "Dream is not what you see in sleep.",
            "Dream is something that does not let you sleep.",
            "To succeed in life and achieve results, understand and control your mind.",
            "Be more dedicated to making solid achievements."
    };

    String[] authors = {
            "Socrates",
            "John Lennon",
            "Dalai Lama",
            "Wayne Gretzky",
            "Mark Twain",
            "Confucius",
            "Buddha",
            "Oprah Winfrey",
            "Marilyn Monroe",
            "Buddha",
            "Steve Jobs",
            "Winston Churchill",
            "Theodore Roosevelt",
            "Eleanor Roosevelt",
            "Nelson Mandela",
            "Sam Levenson",
            "Mark Twain",
            "Confucius",
            "Chris Grosser",
            "Henry David Thoreau",
            "Estee Lauder",
            "Colin Powell",
            "Henry David Thoreau",
            "Mahatma Gandhi",
            "William Shakespeare",
            "Lao Tzu",
            "Aristotle",
            "Eleanor Roosevelt",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam",
            "A. P. J. Abdul Kalam"
    };

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuote = findViewById(R.id.tvQuote);
        tvAuthor = findViewById(R.id.tvAuthor);
        btnNewQuote = findViewById(R.id.btnNewQuote);

        showRandomQuote();

        btnNewQuote.setOnClickListener(v -> showRandomQuote());
    }

    private void showRandomQuote() {
        int index = random.nextInt(quotes.length);

        tvQuote.setText(quotes[index]);
        tvAuthor.setText("- " + authors[index]);
    }
}