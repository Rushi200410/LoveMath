package com.example.lovemaths;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Variables to hold our UI elements
    private TextView textViewQuestion;
    private EditText editTextAnswer;
    private Button buttonSubmit;

    private int correctAnswer; // To store the result of the current problem

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting Java variables to XML IDs
        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        generateNewProblem(); // Start with the first question

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void generateNewProblem() {
        Random random = new Random();
        int num1 = random.nextInt(20) + 1; // Random number 1-20
        int num2 = random.nextInt(20) + 1;
        correctAnswer = num1 + num2;

        textViewQuestion.setText(num1 + " + " + num2 + " = ?");
        editTextAnswer.setText(""); // Clear previous answer
    }

    private void checkAnswer() {
        editTextAnswer.setError(null); // Clears any previous error highlights
        String input = editTextAnswer.getText().toString();
        if (input.isEmpty()) return;

        int userAnswer = Integer.parseInt(input);
        if (userAnswer == correctAnswer) {
            Toast.makeText(this, "Correct! 🌟", Toast.LENGTH_SHORT).show();
            generateNewProblem(); // Move to next unique problem
        } else {
            Toast.makeText(this, "Try Again! ❌", Toast.LENGTH_SHORT).show();
        }
    }
}