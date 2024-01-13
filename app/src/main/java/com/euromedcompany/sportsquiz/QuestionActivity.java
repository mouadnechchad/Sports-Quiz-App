package com.euromedcompany.sportsquiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private CountDownTimer timer;
    private boolean isAnswered = false;
    private Sport selectedSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Retrieve the selected sport from the intent
        selectedSport = getIntent().getParcelableExtra("selectedSport");

        // Create and load questions for the selected sport
        loadQuestions(selectedSport);

        // Display the first question
        displayCurrentQuestion();
    }

    private void loadQuestions(Sport selectedSport) {
        // Replace this with your logic to load questions for the selected sport
        // For now, let's create a sample list of questions for each sport

        switch (selectedSport.getName()) {
            case "Football":
                loadFootballQuestions();
                break;
            case "Basketball":
                loadBasketballQuestions();
                break;
            case "Tennis":
                loadTennisQuestions();
                break;
            case "Volleyball":
                loadVolleyballQuestions();
                break;
            case "Formula 1":
                loadFormula1Questions();
                break;
            case "Athletics":
                loadAthleticsQuestions();
                break;
                // Add cases for other sports...
            default:
                // Handle unknown sport or provide a default set of questions
                //loadDefaultQuestions();
                break;
        }
    }

    private void loadFootballQuestions() {
        // Load football-related questions
        questions = new ArrayList<>();
        questions.add(new Question("Which team won the FIFA World Cup in 2018?", R.drawable.football_1, Arrays.asList("Brazil", "France", "Germany", "Spain"), 1));
        questions.add(new Question("Who is the all-time top scorer in the English Premier League?", R.drawable.football_2, Arrays.asList("Thierry Henry", "Alan Shearer", "Cristiano Ronaldo", "Leonel Messi"), 1));
        questions.add(new Question("In which country did the first World Cup take place?", R.drawable.footbal_3, Arrays.asList("England", "Brazil", "Italy", "Uruguay"), 3));
        questions.add(new Question("Which player is known as 'The Egyptian King' and plays for Liverpool?", R.drawable.football_4, Arrays.asList("Mohamed Salah", "Sadio Mané", "Roberto Firmino", "Marouane Chamakh"), 0));
        questions.add(new Question("Which nation has won the most FIFA World Cup titles?", R.drawable.football_5, Arrays.asList("Germany", "Brazil", "France", "Argentina"), 1));

    }

    private void loadBasketballQuestions() {
        // Load basketball-related questions
        questions = new ArrayList<>();
        questions.add(new Question("Who is the all-time leading scorer in NBA history?", R.drawable.basketball_1, Arrays.asList("Kobe Bryant", "LeBron James", "Kareem Abdul-Jabbar", "Hulk"), 1));
        questions.add(new Question("In which year did Michael Jordan retire from professional basketball for the first time?", R.drawable.basketball_2, Arrays.asList("1993", "1996", "1999", "2003"), 0));
        questions.add(new Question("Which team holds the record for the most NBA championships?", R.drawable.basketball_3, Arrays.asList("Millwaukee Bucks", "Los Angeles Lakers", "Chicago Bulls", "New York Knicks"), 1));
        questions.add(new Question("Who won the NBA MVP award for the 2020-2021 season?", R.drawable.basketball_4, Arrays.asList("Giannis Antetokounmpo", "LeBron James", "Nikola Jokic", "Kobe Bryant"), 2));
        questions.add(new Question("Which NBA player is known for his signature 'skyhook' shot?", R.drawable.basketball_5, Arrays.asList("Shaquille O'Neal", "Hakeem Olajuwon", "Kareem Abdul-Jabbar", "Nikola Jokic"), 2));

    }

    private void loadTennisQuestions() {
        // Load basketball-related questions
        questions = new ArrayList<>();
        questions.add(new Question("Who holds the record for the most Grand Slam singles titles in men's tennis?", R.drawable.tennis_1, Arrays.asList("Rafael Nadal", "Novak Djokovic", "Roger Federer", "Andy Murray"), 1));
        questions.add(new Question("Which Grand Slam tournament is played on clay courts?", R.drawable.tennis_2, Arrays.asList("Wimbledon", "Australian Open", "French Open", "US Open"), 2));
        questions.add(new Question("Who is known as the 'King of Clay' in men's tennis?", R.drawable.tennis_3, Arrays.asList("Novak Djokovic", "Rafael Nadal", "Roger Federer", "Stan Wawrinka"), 1));
        questions.add(new Question("Which female tennis player has won the most Grand Slam singles titles?", R.drawable.tennis_4, Arrays.asList("Serena Williams", "Steffi Graf", "Margaret Court", "Martina Navratilova"), 0));
        questions.add(new Question("In tennis, what is the term for a score of 40-40?", R.drawable.tennis_5, Arrays.asList("Advantage", "Deuce", "Love", "40-40"), 1));

    }

    private void loadVolleyballQuestions(){
        questions = new ArrayList<>();
        questions.add(new Question("Which country has won the most Olympic gold medals in indoor volleyball (men and women combined)?", R.drawable.volleyball_1, Arrays.asList("Brazil", "United States", "Russia", "China"), 1));
        questions.add(new Question("What is the maximum number of hits allowed per side in volleyball before the ball must go over the net?", R.drawable.volleyball_2, Arrays.asList("2", "3", "4", "5"), 1));
        questions.add(new Question("Who was the coach of the USA women's volleyball team that won the 2014 World Championship?", R.drawable.volleyball_3, Arrays.asList("Karch Kiraly", "Jenny Lang Ping", "Hugh McCutcheon", "Giovanni Guidetti"), 0));
        questions.add(new Question("How many players are on the court for each team in indoor volleyball?", R.drawable.volleyball_4, Arrays.asList("5", "6", "7", "8"), 1));
        questions.add(new Question("What is the official diameter of a volleyball?", R.drawable.volleyball_5, Arrays.asList("20.7-21.3 cm", "21.2-22.5 cm", "22.8-23.5 cm", "23.8-24.5 cm"), 0));

    }

    private void loadFormula1Questions(){
        questions = new ArrayList<>();
        questions.add(new Question("Who hold the record for the most Formula 1 World Championships?", R.drawable.formula1_1, Arrays.asList("Michael Schaumakher - Lewis Hamilton", "Ayrton Senna - Max Verstapppen", "Michael Schumacher - Sebastien Vettel", "Sebastian Vettel - Fernando Alonso"), 0));
        questions.add(new Question("Which team has won the most Constructors' Championships in Formula 1?", R.drawable.formula1_2, Arrays.asList("Ferrari", "Mercedes", "Red Bull Racing", "Williams"), 0));
        questions.add(new Question("What is the fuel capacity of a Formula 1 car?", R.drawable.formula1_3, Arrays.asList("90 kg", "100 kg", "110 kg", "120 kg"), 2));
        questions.add(new Question("Who is the youngest Formula 1 World Champion in history?", R.drawable.formula1_4, Arrays.asList("Lewis Hamilton", "Fernando Alonso", "Nico Rosberg", "Sebastian Vettel"), 3));
        questions.add(new Question("In which city is the Circuit de Monaco located?", R.drawable.formula1_5, Arrays.asList("Barcelona", "Monte Carlo", "Monza", "Singapore"), 1));

    }

    private void loadAthleticsQuestions(){
        questions = new ArrayList<>();

        questions.add(new Question("Who holds the world record for the men's 100 meters in athletics?", R.drawable.athletics_1, Arrays.asList("Carl Lewis", "Asafa Powell", "Usain Bolt", "Justin Gatlin"), 2));
        questions.add(new Question("In which events did Usain Bolt win three consecutive Olympic gold medals?", R.drawable.athletics_2, Arrays.asList("100--200 meters", "200-400 meters", "100-4x100 meters relay", "110-400 meters"), 0));
        questions.add(new Question("What is the decathlon in athletics composed of?", R.drawable.athletics_3, Arrays.asList("5 events", "7 events", "10 events", "12 events"), 2));
        questions.add(new Question("Who is often referred to as the 'Flying Finn' in athletics?", R.drawable.athletics_4, Arrays.asList("Paavo Nurmi", "Lasse Viren", "Sebastian Coe", "Hannes Kolehmainen"), 0));
        questions.add(new Question("Which country has historically dominated the women's pole vault in athletics?", R.drawable.athletics_5, Arrays.asList("Russia", "United States", "Germany", "Australia"), 0));
    }

    private void displayCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);

            // Assuming you have TextViews and an ImageView for displaying question details
            TextView questionTextView = findViewById(R.id.questionTextView);
            ImageView questionImageView = findViewById(R.id.questionImageView);

            // Set question text and image
            questionTextView.setText(currentQuestion.getText());
            questionImageView.setImageResource(currentQuestion.getImageResourceId());

            // Assuming you have Buttons for displaying options
            Button option1Button = findViewById(R.id.option1Btn);
            Button option2Button = findViewById(R.id.option2Btn);
            Button option3Button = findViewById(R.id.option3Btn);
            Button option4Button = findViewById(R.id.option4Btn);

            // Set option text
            List<String> options = currentQuestion.getOptions();
            option1Button.setText(options.get(0));
            option2Button.setText(options.get(1));
            option3Button.setText(options.get(2));
            option4Button.setText(options.get(3));

            // Set click listeners for option buttons
            option1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(0);
                }
            });

            option2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(1);
                }
            });

            option3Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(2);
                }
            });

            option4Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(3);
                }
            });
            //Start the timer for 10 seconds
            startTimer(10000);
        } else {
            // No more questions, handle end of quiz
            // You can display a summary, show the score, etc.
            Toast.makeText(this, "End of Quiz", Toast.LENGTH_SHORT).show();
        }
    }

    private void startTimer(long countdownDuration) {
        Chronometer chronometer = findViewById(R.id.chronometer);

        // Calculate the countdown end time in milliseconds
        long countdownEndTime = System.currentTimeMillis() + countdownDuration;

        // Set the base time to the countdown end time
        chronometer.setBase(countdownEndTime);

        // Start the chronometer
        chronometer.start();

        // Set a listener to update the countdown display
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long elapsedMillis = chronometer.getBase() - System.currentTimeMillis();
                long remainingSeconds = elapsedMillis / 1000;

                // Display the remaining seconds
                chronometer.setText(String.valueOf(remainingSeconds));
                // Change text color to red when remaining seconds are less than 3
                if (remainingSeconds <= 3) {
                    chronometer.setTextColor(Color.RED);
                } else {
                    // Reset text color to the default
                    chronometer.setTextColor(Color.BLACK);
                }
                // Check if the countdown is complete
                if (remainingSeconds <= 0) {
                    chronometer.stop();
                    // Handle the end of the countdown (e.g., move to the next question)
                    Toast.makeText(QuestionActivity.this, "Timeout", Toast.LENGTH_SHORT).show();
                    displayCorrectAnswer(questions.get(currentQuestionIndex));
                    beforeNextQuestion();
                }
            }
        });
    }


    private void moveToNextQuestion() {
        // Move to the next question
        currentQuestionIndex++;
        displayCurrentQuestion();

        // Clear the correct answer text
        clearCorrectAnswer();

        // Reset the answer status and start the timer for the next question
        isAnswered = false;
    }

    private void checkAnswer(int selectedOptionIndex) {
        Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.stop();

        Question currentQuestion = questions.get(currentQuestionIndex);

        // Compare the selected option index with the correct answer index
        if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
            // Correct answer, you can update the score or perform other actions
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            // Incorrect answer, you can handle this as needed
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        // Display the correct answer text
        displayCorrectAnswer(currentQuestion);
        beforeNextQuestion();

    }
    private void beforeNextQuestion(){
        // Delay for 3 seconds before moving to the next question
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Move to the next question
                currentQuestionIndex++;
                displayCurrentQuestion();

                // Clear the correct answer text
                clearCorrectAnswer();

                // Check if this was the last question
                if (currentQuestionIndex == questions.size()) {
                    // No more questions, handle end of quiz
                    // Display a summary, show the score, etc.
                    Toast.makeText(QuestionActivity.this, "Quiz completed", Toast.LENGTH_SHORT).show();
                    //return to ChooseSportActivity
                    navigateToChooseSportActivity();
                }
            }
        }, 3000); // 3000 milliseconds = 3 seconds
    }
    private void displayCorrectAnswer(Question question) {
        // Find the correctAnswerTextView
        TextView correctAnswerTextView = findViewById(R.id.correctAnswerTextView);

        // Display the correct answer text
        String correctAnswerText = "Correct Answer: " + question.getOptions().get(question.getCorrectOptionIndex());
        correctAnswerTextView.setText(correctAnswerText);
    }

    private void clearCorrectAnswer() {
        // Find the correctAnswerTextView
        TextView correctAnswerTextView = findViewById(R.id.correctAnswerTextView);

        // Clear the correct answer text
        correctAnswerTextView.setText("");
    }
    private void navigateToChooseSportActivity() {
        // Create an Intent to navigate back to ChooseSportActivity
        Intent intent = new Intent(QuestionActivity.this, ChooseSportActivity.class);
        startActivity(intent);
        finish(); // Close the current activity
    }
}
