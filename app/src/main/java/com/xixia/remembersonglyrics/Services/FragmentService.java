package com.xixia.remembersonglyrics.Services;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import com.xixia.remembersonglyrics.R;
import com.xixia.remembersonglyrics.UI.MainActivity;

/**
 * Created by macbook on 7/31/17.
 */

public class FragmentService {
    // use this to handle all fragment transactions
    private static AppCompatActivity activity;
    private static FragmentManager fm;

    public FragmentService (Activity activity) {
        this.activity = (AppCompatActivity)activity;
        fm = ((AppCompatActivity) activity).getSupportFragmentManager();
    }

    public static void loadFragment (Fragment fragment, int containerViewId) {
            int containerID = containerViewId;
        // Enter transition set for fragment
        Fade enterFade = new Fade ();
        enterFade.setDuration(500);
        fragment.setEnterTransition(enterFade);
        // set transition fade for exit of fragment
        Fade exitFade = new Fade();
        exitFade.setDuration(200);
        fragment.setExitTransition(exitFade);
        fm.beginTransaction().replace(containerID, fragment).addToBackStack(null).commit();

//        if(fragment.toString().contains("MicFragment")) {
//            fragmentManager.beginTransaction().replace(R.id.content2_frame, fragment).addToBackStack(null).commit();
//        } else if (fragment.toString().contains("Instructions")) {
//            fragmentManager.beginTransaction().replace(R.id.content2_frame, fragment).addToBackStack(null).commit();
//        } else if (fragment.toString().contains("Search")) {
//            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("Search").commit();
//        } else if (fragment.toString().contains("Verses")) {
//            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, "Verses").addToBackStack("Verses").commit();
//        }
    }
}
