package com.example.android.quizapp_ver3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This quiz app is about US baseball major league.
 */

public class MainActivity extends AppCompatActivity {

    int scoreForQuestion1 = 0;
    int scoreForQuestion2 = 0;
    int scoreForQuestion3 = 0;
    int scoreForQuestion4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Check the Answer button is clicked.
     */

    public void submitAnswer(View view) {

        /**
         * For Question 1
         * The answer is "Boston".
         */
        EditText redSox = findViewById(R.id.redSox);
        String cityName = redSox.getText().toString();

        if (cityName.equalsIgnoreCase("Boston")) {
            scoreForQuestion1 = 5;
        } else {
            scoreForQuestion1 = 0;
        }

        /**
         * For Question 2
         * The answer is 2nd option - Moose.
         */
        RadioButton mascot = findViewById(R.id.moose);

        if (mascot.isChecked()) {
            scoreForQuestion2 = 5;
        }

        /**
         * For Question 3
         * The answer is 1st & 3rd options - 1907 & 2014.
         */
        CheckBox CheckBoxOption1 = findViewById(R.id.option_1);
        boolean checkedOption1 = CheckBoxOption1.isChecked();

        CheckBox CheckBoxOption3 = findViewById(R.id.option_3);
        boolean checkedOption3 = CheckBoxOption3.isChecked();

        CheckBox CheckBoxOption2 = findViewById(R.id.option_2);
        boolean checkedOption2 = CheckBoxOption2.isChecked();

        CheckBox CheckBoxOption4 = findViewById(R.id.option_4);
        boolean checkedOption4 = CheckBoxOption4.isChecked();

        int scoreForQuestion3 = scoreQuestion3(checkedOption1, checkedOption3, checkedOption2, checkedOption4);

        /**
         * For Question 4
         * The answer is "Giants".
         */
        EditText sanFrancisco = findViewById(R.id.sanFrancisco);
        String teamName = sanFrancisco.getText().toString();

        if (teamName.equalsIgnoreCase("Giants")) {
            scoreForQuestion4 = 5;
        } else {
            scoreForQuestion4 = 0;
        }

        String finalMessage  = createScoreSummary(scoreForQuestion1, scoreForQuestion2, scoreForQuestion3, scoreForQuestion4);

        /**
         * Toast message for total score.
         */
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, finalMessage, duration);
        toast.show();
    }


    /**
     * This method is to get score from question 3.
     *
     * @param hasOption1 1st right answer
     * @param hasOption3 2nd right answer
     * @return gained score
     */
    public int scoreQuestion3(boolean hasOption1, boolean hasOption3, boolean hasOption2, boolean hasOption4) {

        if (hasOption1 && hasOption3 && !hasOption2 && !hasOption4) {
            scoreForQuestion3 = 5;
        }
        else {
            scoreForQuestion3 = 0;
        }

        return scoreForQuestion3;
    }


    /**
     * This method is to get the final message about total score.

     */
    private String createScoreSummary(int scoreForQuestion1, int scoreForQuestion2, int scoreForQuestion3, int scoreForQuestion4) {
        int finalScore = scoreForQuestion1 + scoreForQuestion2 + scoreForQuestion3 + scoreForQuestion4;
        String finalMessage = "Your total score is " + finalScore;
        return finalMessage;
    }

}
