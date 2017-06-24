package ca.dane.nait.dmit.asynctaskdemo02;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dchristenson5 on 6/23/2017.
 */

public class DownloadImageTask extends AsyncTask<String, Integer, Bitmap> {

    private ProgressBar mProgressBar;
    private Button mButton;
    private ImageView mImageView;

    public DownloadImageTask(ProgressBar progressBar, Button button, ImageView imageView){
        mProgressBar = progressBar;
        mButton = button;
        mImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String urlString = params[0];
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            final int BUFFER_SIZE = 1024;
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while((bytesRead = inputStream.read(buffer)) != -1){
                baos.write(buffer, 0, bytesRead);
            }
            return BitmapFactory.decodeByteArray(baos.toByteArray(), 0, baos.size());
        } catch (Exception e) {
            Log.e("DownloadImageTask", e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
//        super.onPreExecute();
        mButton.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
//        super.onPostExecute(bitmap);
        mButton.setEnabled(true);
        mImageView.setImageBitmap(bitmap);
    }
}
