package ca.dane.nait.dmit.itunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchTermEditText;
    private ListView mResultsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchTermEditText = (EditText) findViewById(R.id.activity_main_searchTermEditText);
        mResultsListView = (ListView) findViewById(R.id.main_activity_searchResultsListView);
    }
    public void onSearchClicked (View view){
        final String searchTerm = mSearchTermEditText.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://itunes.apple.com/search?medium=music&entity=song&term=" + searchTerm;

    }

}
