package ca.nait.dmit.webviewdemo01;

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

    public void navigateToUrl(View view){
        EditText urlEditText = (EditText) findViewById(R.id.urlEditText);
        String urlString = urlEditText.getText().toString();

        Intent webviewIntent = new Intent(this, WebViewActivity.class);
        webviewIntent.putExtra("TARGET_URL", urlString);
        startActivity(webviewIntent);
    }
}
