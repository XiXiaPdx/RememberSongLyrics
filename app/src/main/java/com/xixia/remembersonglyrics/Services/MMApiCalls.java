package com.xixia.remembersonglyrics.Services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.xixia.remembersonglyrics.Models.EachTrack;
import com.xixia.remembersonglyrics.Models.LyricsModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.xixia.remembersonglyrics.Constants.MUSIC_MATCH_KEY;

/**
 * Created by macbook on 7/31/17.
 */

public class MMApiCalls {
    private final static String TAG = "MMApiCalls";
    private static AppData appData = AppData.getInstance();
    private static Context mContext;

    public MMApiCalls(Context context){
        mContext = context;
    }


    public static void getLyricsCall(int songId){
        MMClient client = MMServiceGenerator.createService(MMClient.class);
        Observable<LyricsModel> call = client.songLyrics(Integer.toString(songId), MUSIC_MATCH_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        //observer
        Observer<LyricsModel> observer = new Observer<LyricsModel>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe" + Thread.currentThread().getName());
            }

            @Override
            public void onNext(LyricsModel value) {
                String lyrics = value.getMessage().getBody().getLyrics().getLyrics_body();
                //do something with lyrics
                Log.e(TAG, "onNext: " +  value.getMessage().getBody().getLyrics().getLyrics_body()+ Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: All Done!" + Thread.currentThread().getName());
            }

        };
        call.subscribe(observer);
    }

    public static void searchForSong(String searchTerms){
        MMClient client = MMServiceGenerator.createService(MMClient.class);
        Observable<LyricsModel> call = client.songSearch(searchTerms, MUSIC_MATCH_KEY, "true", "5")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<LyricsModel> observer = new Observer<LyricsModel>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe" + Thread.currentThread().getName());
            }

            @Override
            public void onNext(LyricsModel value) {
                Log.e(TAG, "onNext: "  + Thread.currentThread().getName());
                List<EachTrack> trackList = value.getMessage().getBody().getTrack_list();
                try {
                    getLyricsCall(trackList.get(0).getTrack().getTrack_id());
                    String trackName = trackList.get(0).getTrack().getTrack_name();
                    String artistName = trackList.get(0).getTrack().getArtist_name();
                    appData.setArtistName(artistName);
                    appData.setTrackName(trackName);
                } catch (IndexOutOfBoundsException e){
                    searchError();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: All Done!" + Thread.currentThread().getName());
            }

        };
        call.subscribe(observer);
    }

    public static void searchError() {
        Toast.makeText(mContext, "Sorry, we don't have lyrics for that song.", Toast.LENGTH_SHORT).show();
    }

}
