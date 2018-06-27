package com.example.aziz.testapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Aziz on 6/26/2018
 */

public abstract class GetTask extends AsyncTask<String, String, String> {

    protected Context context;
    protected ProgressDialog progressDialog;
    protected byte[] responseBytes;
    protected boolean showDialog = true;


    public GetTask(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please Wait...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        try {
            if (showDialog)
                progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(String... uri) {
        Response response;
        String responseBody;
        try {
            OkHttpClient client = new OkHttpClient.Builder() .build();
            Request request = new Request.Builder() .url(uri[0]) .build();
            Log.d("tag", uri[0]);
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                responseBytes = response.body().bytes();
                responseBody = new String(responseBytes);
                Log.i("body",responseBody);
            } else if(response.message().equalsIgnoreCase("Not Found")){
                responseBody = response.body().string();
            }else
                responseBody = "timeout";
            response.close();
        } catch (Exception e) {
            responseBody = "timeout";
            e.printStackTrace();
        }
        return responseBody;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        onPost(result);
        try {
            if (showDialog)
                progressDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void onPost(String result);
}
