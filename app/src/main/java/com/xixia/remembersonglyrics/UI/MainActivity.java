package com.xixia.remembersonglyrics.UI;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xixia.remembersonglyrics.R;
import com.xixia.remembersonglyrics.Services.MMApiCalls;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onResume(){
        super.onResume();
        MMApiCalls apiCallService = new MMApiCalls(this);
        apiCallService.searchForSong("Million Reasons Lady Gaga");
    }
}
