package ca.dane.dmit.quiz02danechristenson;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
private TrackAdapter mTrackAdapter;
    private ListView mListView;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayList<Track> tracks = new ArrayList<>();
//        for(int i = 0; i<tracks.size(); i++){
//            Track currentTrack = tracks.get(i);
//            String date = currentTrack.getDate().toString();
//            String description = currentTrack.getDescription();
//            String amount = currentTrack.getAmount()+"";
//
//            Track currentTrack = new Track();
//            currentJitter.sender = sender;
//            currentJitter.date = date;
//            currentJitter.text = text;
//            //add to list
//            jitters.add(currentJitter);
//        }
        mListView = (ListView) findViewById(R.id.ListView);

        TrackRepository trackRepo = TrackRepository.getInstance(this);
        ArrayList<Track> tracks = (ArrayList<Track>) trackRepo.getTrack();
        mTrackAdapter = new TrackAdapter(this, tracks);



    }

}
