package com.xixia.remembersonglyrics.Models;

/**
 * Created by macbook on 7/31/17.
 */

public class Track {
    private int track_id;
    private String track_name;
    private String artist_name;

    public String getArtist_name(){
        return artist_name;
    }
    public int getTrack_id() {
        return track_id;
    }

    public String getTrack_name() {
        return track_name;
    }
}
