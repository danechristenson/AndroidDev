package ca.dane.nait.dmit.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final int max = 100;
    final int min = 0;
    public int random = new Random().nextInt((max - min) + 1) + min;
    public int numberOfGuessesInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText guessEdit = (EditText) findViewById(R.id.answerEditText);
        guessEdit.setText("0");

        numberOfGuessesInt = 0;
        TextView range = (TextView) findViewById(R.id.betweenTextView);

        range.setText(String.format("%s and %s", max, min));

    }

    public void guessNumber(View view){
        EditText guessEdit = (EditText) findViewById(R.id.answerEditText);
        TextView guessOut = (TextView) findViewById(R.id.guessWasTextView);
        TextView numberOfGuesses = (TextView) findViewById(R.id.numberOfGuessesTextView);
        int guess;

        guess = Integer.parseInt(guessEdit.getText().toString());

        if(guess == random) {
            guessOut.setText("You Guessed it!");
            numberOfGuessesInt = 0;
            numberOfGuesses.setText(String.valueOf(numberOfGuessesInt));
            random = new Random().nextInt((max-min)+1) + min;

        } else if(guess > random) {
            guessOut.setText("Your guess was too High");
            numberOfGuessesInt++;
            numberOfGuesses.setText(String.valueOf(numberOfGuessesInt));
            guessEdit.setText("");

        } else if (guess < random){
            guessOut.setText("Your guess was too Low");
            numberOfGuessesInt++;
            numberOfGuesses.setText(String.valueOf(numberOfGuessesInt));
            guessEdit.setText("");
        }
    }
}
