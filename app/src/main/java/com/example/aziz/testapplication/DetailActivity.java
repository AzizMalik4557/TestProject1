package com.example.aziz.testapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import org.json.JSONException;
import org.json.JSONObject;



public class DetailActivity extends AppCompatActivity {

    TextView nameView, emailView;
    ImageView userImageView;
    RecyclerView follower_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        nameView = findViewById(R.id.text_name);
        emailView = findViewById(R.id.text_email);
        userImageView = findViewById(R.id.image_user);
        follower_view = findViewById(R.id.recycler_followers);

        String result = getIntent().getStringExtra("result");
        try {
            JSONObject resJsonObject = new JSONObject(result);
            nameView.setText( "User Name:   "+resJsonObject.optString("login"));
            emailView.setText("User Email:  "+resJsonObject.optString("email"));

            String image_url = resJsonObject.optString("avatar_url");
            Picasso.get()
                    .load(image_url)
                    .resize(250, 250)
                    .centerCrop()
                    .into(userImageView);

            FollowersGetTask task = new FollowersGetTask(DetailActivity.this, follower_view);
            task.execute(resJsonObject.optString("followers_url"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
