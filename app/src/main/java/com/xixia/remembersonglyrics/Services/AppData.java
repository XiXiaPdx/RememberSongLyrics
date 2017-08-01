package com.xixia.remembersonglyrics.Services;

/**
 * Created by macbook on 7/31/17.
 */

public class AppData {
    private static final AppData ourInstance = new AppData();
    private String trackName;
    private String artistName;

    public static AppData getInstance() {
        return ourInstance;
    }

    private AppData() {
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
}
