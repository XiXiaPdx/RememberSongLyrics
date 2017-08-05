package com.xixia.remembersonglyrics.UI;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xixia.remembersonglyrics.R;
import com.xixia.remembersonglyrics.Services.FragmentService;
import com.xixia.remembersonglyrics.Services.MMApiCalls;

public class MainActivity extends AppCompatActivity implements SplashFragment.OnFragmentInteractionListener {
    private FragmentService fragmentService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentService = new FragmentService(this);

    }

    @Override
    protected void onResume(){
        super.onResume();
//        MMApiCalls apiCallService = new MMApiCalls(this);
//        apiCallService.searchForSong("Million Reasons Lady Gaga");
        fragmentService.loadFragment(SplashFragment.newInstance());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
