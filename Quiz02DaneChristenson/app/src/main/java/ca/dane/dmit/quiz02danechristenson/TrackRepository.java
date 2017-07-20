package ca.dane.dmit.quiz02danechristenson;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by dchristenson5 on 7/19/2017.
 */

public class TrackRepository {
    private static TrackRepository sTrackRepository;
    private List<Track> mTracks;

    public static TrackRepository getInstance(Context context) {
        if (sTrackRepository == null) {
            sTrackRepository = new TrackRepository(context);
        }
        return sTrackRepository;
    }

    private TrackRepository(Context context) {
        mTracks = new ArrayList<>();
        //create 100 sample expenses;
        Random numberGenerator = new Random();
        for (int i = 1; i <= 50; i++) {
            Track currentTrack = new Track();
            currentTrack.setDescription("Track #" + i);
            //assign a random amount between 1 and 100;
            currentTrack.setAmount(Math.round(numberGenerator.nextDouble() * 1000.0) / 100.0);
            mTracks.add(currentTrack);
        }
    }

    public List<Track> getTrack() {
        return mTracks;
    }

    public Track getTrack(UUID id) {
        for (Track currentTrack : mTracks) {
            if (currentTrack.getId().equals(id)) {
                return currentTrack;
            }
        }

        return null;
    }
}
