package ca.dane.nait.dmit.asynctaskdemo01;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dchristenson5 on 6/21/2017.
 */

public class DownloadTask extends AsyncTask<String, Void, Void> {
    private ProgressBar mProgressBar;


    @Override
    protected Void doInBackground(String... params) {
        String urlString = params[0];
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            InputStream is = new BufferedInputStream(connection.getInputStream());
        } catch (Exception ex){
            Log.e("Network Error: ", ex.getMessage());
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
