package ca.nait.dmit.helloworld01;

import android.icu.text.MessageFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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

//        helloButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                //event handler code
//                changeGreeting(v);
//            }
//        });
        helloButton.setOnClickListener(this);
    }

    public void changeGreeting(View view){

        String username = userNameEditText.getText().toString();
        String usernameString = username;
        if (username.length() ==0){
            usernameString = "World";
        }
        String greeting = "Hello, " + usernameString;
        userNameTextView.setText(greeting);

        Toast toast = Toast.makeText(this, greeting, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        changeGreeting(v);
    }
}
