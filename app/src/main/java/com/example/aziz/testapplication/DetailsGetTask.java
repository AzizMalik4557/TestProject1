package com.example.aziz.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONObject;
import java.util.ArrayList;


/**
 * Created by Aziz on 6/26/2018
 */
public class DetailsGetTask extends GetTask {

    private Activity activity;

    private RecyclerView mRecyclerView;
    private ArrayList<Details> detailsList;


    //Constructor to initialize Activity and RecyclerView
    public DetailsGetTask(Activity activity, RecyclerView recyclerView) {
        super(activity);
        this.activity = activity;
        this.mRecyclerView = recyclerView;
    }

    public DetailsGetTask(Activity activity) {
        super(activity);
        this.activity = activity;

    }

    @Override
    protected void onPost(String result) {
        detailsList = new ArrayList<>();
        Log.i("result", result);
        if (result.equalsIgnoreCase("timeout")) {
            Util.makeAlert(context, "connection timeout").show();

        } else try {
            JSONObject resultObject = new JSONObject(result);
            if (!resultObject.optString("message").equalsIgnoreCase("Not Found")) {
                Intent i =new Intent(context,DetailActivity.class);
                i.putExtra("result",result);
                context.startActivity(i);

            } else {
                Util.makeAlert(context, "Not found").show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
