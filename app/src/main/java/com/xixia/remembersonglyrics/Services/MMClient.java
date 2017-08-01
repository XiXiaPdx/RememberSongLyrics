package com.xixia.remembersonglyrics.Services;

import com.xixia.remembersonglyrics.Models.LyricsModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by macbook on 7/31/17.
 */

public interface MMClient {
    @GET("track.lyrics.get")
    Observable<LyricsModel> songLyrics(
            @Query("track_id") String songID,
            @Query ("apikey") String apiKey
    );

    @GET("track.search")
    Observable <LyricsModel> songSearch(
            @Query("q_track_artist") String songSearchTerms,
            @Query ("apikey") String apiKey,
            @Query("f_has_lyrics") String hasLyrics,
            @Query("page_size") String numberOfResults
    );
}
