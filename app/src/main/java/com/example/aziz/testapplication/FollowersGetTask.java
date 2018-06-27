package com.example.aziz.testapplication;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Aziz on 6/26/2018
 */
public class FollowersGetTask extends GetTask {

    private Activity activity;

    private RecyclerView mRecyclerView;
    public ArrayList<Followers> followersArrayList;


    //Constructor to initialize Activity and RecyclerView
    public FollowersGetTask(Activity activity, RecyclerView recyclerView) {
        super(activity);
        this.activity = activity;
        this.mRecyclerView = recyclerView;
    }

    public FollowersGetTask(Activity activity) {
        super(activity);
        this.activity = activity;

    }

    //Getting Followers Information in Json Form
    @Override
    protected void onPost(String result) {
        followersArrayList = new ArrayList<>();
        Log.i("result", result);
        if (result.equalsIgnoreCase("timeout")) {
            Util.makeAlert(context, "connection timeout").show();

        } else try {

            JSONArray resultObject = new JSONArray(result);
            if (resultObject.length() != 0) {
                for (int i=0; i< resultObject.length();i++) {
                    JSONObject jsonObject=resultObject.optJSONObject(i);
                    followersArrayList.add(new Followers(jsonObject.optString("login") ,jsonObject.optString("avatar_url")));
                }
            } else {
                Toast.makeText(activity, "Not found", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        FollowersAdopter adapter = new FollowersAdopter(followersArrayList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

    }
}
