package ca.nait.dmit.quiz01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected  String[] questions = {"What is the most used OS for mobile?", "Where is Alberta's capital city?",
        "How much wood could a woodchuck chuck if a wood chuck could chuck wood?",
        "What is the answer to life and everything?"};
    protected String[] answers = {"Android", "Edmonton", "42 Cords", "42"};
    protected int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize values
        i = 0;
        TextView question = (TextView) findViewById(R.id.question);
        TextView answer = (TextView) findViewById(R.id.questionAnswer);
        question.setText(questions[i]);
        answer.setText("");
    }

    public void nextQuestion(View view){
        TextView questionNext = (TextView) findViewById(R.id.question);
        if(i+1 >= questions.length){
            i=0;
        } else{
            i++;
        }

        String question = questions[i];
        questionNext.setText(question);

    }

    public void answerQuestion(View view){
        TextView questionAnswer = (TextView) findViewById(R.id.questionAnswer);

        String answer = answers[i];
        questionAnswer.setText(answer);
    }
}
