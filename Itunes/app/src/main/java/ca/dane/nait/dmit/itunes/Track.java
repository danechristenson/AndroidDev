package ca.dane.nait.dmit.itunes;

import java.net.URL;

/**
 * Created by dchristenson5 on 6/19/2017.
 */

public class Track {


    private String trackName;
    private String artistName;
    private URL previewUrl;
    private URL artworkUrl;
    private URL artworkUrl100;

    public URL getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(URL previewUrl) {
        this.previewUrl = previewUrl;
    }


    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public URL getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(URL artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public URL getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(URL artworkUrl) {
        this.artworkUrl = artworkUrl;
    }
}
