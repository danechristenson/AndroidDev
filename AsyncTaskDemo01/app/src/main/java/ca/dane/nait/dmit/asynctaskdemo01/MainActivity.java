package ca.dane.nait.dmit.asynctaskdemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDownloadClick(View view){

//        new Thread(new Runnable(){
//            @Override
//            public void run(){
//                HttpURLConnection connection = null;
//                try {
//                    URL url = new URL("https://bitbucket.org/product");
//                    connection = (HttpURLConnection) url.openConnection();
//                    InputStream is = new BufferedInputStream(connection.getInputStream());
//                } catch (Exception ex){
//                    Log.e("Network Error: ", ex.getMessage());
//                } finally {
//                    if(connection != null) {
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();

        new DownloadTask().execute("https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjjr5XumdDUAhVY0mMKHd5cD5YQjRwIBw&url=https%3A%2F%2Fwall.alphacoders.com%2Fby_sub_category.php%3Fid%3D211881&psig=AFQjCNGSqIGDX7vXrUpQBrsrkhrF-WPuAw&ust=1498177932485543");


    }

}
