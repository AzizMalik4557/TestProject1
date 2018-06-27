package com.example.aziz.testapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Aziz Malik on 6/27/2018.
 */

public class FollowersAdopter extends RecyclerView.Adapter<FollowersAdopter.MyViewHolder> {

    private List<Followers> detailsList;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView followerLogin;
        public ImageView followerImage;



        public MyViewHolder(View view) {
            super(view);


            followerLogin =  view.findViewById(R.id.text_follower_login);
            followerImage =  view.findViewById(R.id.view_follower_image);

        }

    }
    public FollowersAdopter(List<Followers> patientsList)
    {
        this.detailsList = patientsList;
    }

    @Override

    public FollowersAdopter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


                View viewONE = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
                MyViewHolder rowONE = new MyViewHolder(viewONE);
                return rowONE;
    }

    //Binding View Holder
    @Override
    public void onBindViewHolder(FollowersAdopter.MyViewHolder holder, int position) {


        Followers followers = detailsList.get(position);
        holder.followerLogin.setText(followers.getFollowerLogin());
        Picasso.get()
                .load(followers.getFollowerImage())
                .resize(50, 50)
                .centerCrop()
                .into(holder.followerImage);

    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }
}
