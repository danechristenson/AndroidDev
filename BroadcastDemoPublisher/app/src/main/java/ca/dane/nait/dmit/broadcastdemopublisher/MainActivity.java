package ca.dane.nait.dmit.broadcastdemopublisher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBroadcastButton (View view){
EditText messageEditText = (EditText) findViewById(R.id.editText);
        Intent intent = new Intent();
        intent.setAction("ca.nait.dmit2504.NOTIFICATION");
        intent.putExtra("data", messageEditText.getText().toString());
        sendBroadcast(intent);

    }
}
