package com.example.mrfre.pova;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Application;
import android.util.Log;

import java.util.List;

public class Server extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ac9e03c76cbc07ab29129ca68ed330830148f244")
                // if desired
                .clientKey("41d70b40e22a0d49437d54d5a3abef256fff3308")
                .server("http://54.183.188.53:80/parse/")
                .build()
        );
    }
}