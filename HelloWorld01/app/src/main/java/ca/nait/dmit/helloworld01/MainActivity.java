package ca.nait.dmit.helloworld01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private TextView userNameTextView;
    private Button helloButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        userNameTextView = (TextView) findViewById(R.id.usernameTextView);
        helloButton = (Button) findViewById(R.id.helloButton);
    }

    public void changeGreeting(View view){

    }

}
