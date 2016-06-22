package com.example.tapesh.fireproject1;

import com.firebase.client.Firebase;

/**
 * Created by TAPESH on 4/21/2016.
 */
public class CrowdWeather extends android.app.Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
