package com.example.aziz.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public EditText userSearch;
    public Button searchButton;
    DetailsGetTask task;
    private RecyclerView recyclerView;
    String api_url = "https://api.github.com/users/mob" ;
    String search_user = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = (Button) findViewById(R.id.searchButton);
        userSearch = (EditText) findViewById(R.id.edit_query1);



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_user = userSearch.getText().toString();
                api_url = "https://api.github.com/users/"+search_user;
                Log.i("url",api_url);
                task = new DetailsGetTask(MainActivity.this, recyclerView);
                task.execute(api_url);
            }
        });

    }
}
