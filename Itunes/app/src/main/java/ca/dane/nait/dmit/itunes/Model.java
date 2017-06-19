package ca.dane.nait.dmit.itunes;

import java.util.List;

/**
 * Created by dchristenson5 on 6/19/2017.
 */

public class Model {
    private int resultCount;
    private List<Track> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Track> getResults() {
        return results;
    }

    public void setResults(List<Track> results) {
        this.results = results;
    }



}
