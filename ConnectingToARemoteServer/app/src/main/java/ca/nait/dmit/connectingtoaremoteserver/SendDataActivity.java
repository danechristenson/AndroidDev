package ca.nait.dmit.connectingtoaremoteserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SendDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
    }

    public void viewJitters(View view){
        Intent recieveDataIntent = new Intent(this, ReceiveDataActivity.class);
        startActivity(recieveDataIntent);
    }
}
