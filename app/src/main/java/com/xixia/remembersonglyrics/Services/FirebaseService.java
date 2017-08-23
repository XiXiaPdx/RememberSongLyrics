package com.xixia.remembersonglyrics.Services;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by macbook on 8/7/17.
 */

public class FirebaseService {
    private static final FirebaseService firebaseService = new FirebaseService();
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference ref = database.getReference();

    private FirebaseService(){};

    public static FirebaseDatabase getFBDatabaseInstance () {
        return firebaseService.database;
    }


    public static FirebaseDatabase getDatabase() {
        return database;
    }

    public static DatabaseReference getRef() {
        return ref;
    }
}
