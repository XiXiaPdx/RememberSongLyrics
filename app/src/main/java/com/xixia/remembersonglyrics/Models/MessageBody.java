package com.xixia.remembersonglyrics.Models;

import java.util.List;

/**
 * Created by macbook on 7/31/17.
 */

public class MessageBody {
    Lyrics lyrics;
    List<EachTrack> track_list;
    public MessageBody() {};
    public Lyrics getLyrics() {
        return lyrics;
    }
    public List<EachTrack> getTrack_list() {
        return track_list;
    }
}
