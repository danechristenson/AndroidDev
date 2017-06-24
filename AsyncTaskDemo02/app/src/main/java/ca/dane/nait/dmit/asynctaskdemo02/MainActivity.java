package ca.dane.nait.dmit.asynctaskdemo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private Button mButton;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.main_activity_downloadProgressBar);
        mButton = (Button) findViewById(R.id.main_activity_downloadButton);
        mImageView = (ImageView) findViewById(R.id.main_activity_downloadImageView);
    }

    public void onDownloadImage(View view){

         DownloadImageTask imageTask = new DownloadImageTask(mProgressBar, mButton,mImageView);
        imageTask.execute("http://www.guidingtech.com/assets/postimages/2016/03/disable-physical-button-android.png");
//        imageTask.execute("http://wallpaperpulse.com/img/1124782.jpg");
    }
}
