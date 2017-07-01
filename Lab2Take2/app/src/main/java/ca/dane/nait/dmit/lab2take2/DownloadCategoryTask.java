package ca.dane.nait.dmit.lab2take2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

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
        BufferedReader in = null;
        ArrayList jitters = new ArrayList();
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

            in = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            String NL = System.getProperty("line.separator");

            while((line = in.readLine()) != null)
            {
                jitters.add(line);
            }
            in.close();

        } catch (Exception ex){
            Log.e("Network Error: ", ex.getMessage());
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }



        return jitters ;
    }
    @Override
    protected void onPostExecute(List<String> data) {
        final List<String> newdata = data;
        ArrayAdapter<String> results = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(results);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("category", newdata.get(position));
                Toast.makeText(mContext, newdata.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
