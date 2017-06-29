package ca.dane.nait.dmit.lab2take2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by dchristenson5 on 6/28/2017.
 */


public class DownloadCategoryTask extends AsyncTask<String, Void, List<String>> {
    private ListView mListView;
    private Context mContext;

    public DownloadCategoryTask(Context context, ListView listView){
        mContext = context;
        mListView = listView;
    }
    @Override
    protected List<String> doInBackground(String... params) {
        String urlString = params[0];
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
        } catch (Exception ex){
            Log.e("Network Error: ", ex.getMessage());
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
        return null ;
    }
    @Override
    protected void onPostExecute(List<String> string) {
        ArrayAdapter<String> results = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, string);
        for (int i = 0; i < string.size(); ++i){
            results.add(string.get(i));
        }


        mListView.setAdapter(results);
    }

}
