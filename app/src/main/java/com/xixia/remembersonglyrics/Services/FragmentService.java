package com.xixia.remembersonglyrics.Services;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.Fade;

import com.xixia.remembersonglyrics.R;

/**
 * Created by macbook on 7/31/17.
 */

public class FragmentService {
    // use this to handle all fragment transactions

    private static final FragmentService ourInstance = new FragmentService();

    private FragmentService () {}

    public static FragmentManager fragmentManager;

    public static FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public static FragmentService getInstance() {
        return ourInstance;
    }

    public static void loadFragment (Fragment fragment) {
        // Enter transition set for fragment
        Fade enterFade = new Fade ();
        enterFade.setDuration(500);
        fragment.setEnterTransition(enterFade);
        // set transition fade for exit of fragment
        Fade exitFade = new Fade();
        exitFade.setDuration(200);
        fragment.setExitTransition(exitFade);

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
