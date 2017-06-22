package ca.dane.nait.dmit.asynctaskdemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDownloadClick(View view){

        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://bitbucket.org/product");
            connection = (HttpURLConnection) url.openConnection();
        } catch (Exception ex){
            Toast.makeText(this, "Network Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }

    }

}
