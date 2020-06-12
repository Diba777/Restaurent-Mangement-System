package com.example.bmnseats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FindNearestPoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_nearest_point);

        Intent intent=new Intent(FindNearestPoint.this,SeeDirection.class);
        startActivity(intent);
    }
}
