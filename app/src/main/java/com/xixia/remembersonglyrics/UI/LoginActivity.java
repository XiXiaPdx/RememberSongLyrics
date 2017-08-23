package com.xixia.remembersonglyrics.UI;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xixia.remembersonglyrics.Constants;
import com.xixia.remembersonglyrics.R;
import com.xixia.remembersonglyrics.Services.FragmentService;

public class LoginActivity extends AppCompatActivity implements EmailFragment.OnFragmentInteractionListener {
    private FragmentService fragmentService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentService = new FragmentService(this);
        testVarArgs(1,2);

    }

    @Override
    protected void onResume(){
        super.onResume();
//        MMApiCalls apiCallService = new MMApiCalls(this);
//        apiCallService.searchForSong("Million Reasons Lady Gaga");
        fragmentService.loadFragment(EmailFragment.newInstance(), Constants.LOGIN_CONTAINER);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void testVarArgs(int... numbers){
        for (int number: numbers){
            System.out.println(number);
        }
    }
}
