package ca.dane.nait.dmit.dialoguedemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private int mCurrentProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showAlertDialog(View view){
        //create instance of dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //set the display title and message
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to continue?");
        //Stop the back button from clearing the dialog
        builder.setCancelable(false);
        // configure the text and listener for the yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "thanks", Toast.LENGTH_SHORT).show();
            }
        });
        //configure the text and listener for the no button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "That makes me sad", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    public void showProgressDialog(View view){
        //create an instance of the progress
        mProgressDialog = new ProgressDialog(this);
        //Set the title and message
        mProgressDialog.setTitle("Downloading data");
        mProgressDialog.setMessage("Please wait, this might take a while");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();

        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mProgressDialog.dismiss();
            }
        }.start();
    }

    public void showProgressUpdateDialog(View view){
        //create an instance of the progress
        mProgressDialog = new ProgressDialog(this);
        //Set the title and message
        mProgressDialog.setTitle("Downloading data");
        mProgressDialog.setMessage("Please wait, this might take a while");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setProgress(mCurrentProgress);
        mProgressDialog.setMax(10);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();

        new CountDownTimer(10000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                mProgressDialog.setProgress(++mCurrentProgress);
            }

            @Override
            public void onFinish() {
                mProgressDialog.setProgress(mCurrentProgress);
                mProgressDialog.dismiss();
                mCurrentProgress = 0;
            }
        }.start();


    }

    public void showDatePickerDialog(View view){

    }

    public void showTimePickerDialog(View view){

    }

}
