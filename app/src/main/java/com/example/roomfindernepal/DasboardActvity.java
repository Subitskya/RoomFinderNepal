package com.example.roomfindernepal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DasboardActvity extends AppCompatActivity {

    private RecyclerView recV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard_actvity);

        recV = findViewById(R.id.recV_id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recV.setLayoutManager(linearLayoutManager);

        List<singleModelClass> roomList = new ArrayList<>();
        roomList.add(new singleModelClass(R.drawable.room, "Flat", "Availabe"));
        roomList.add(new singleModelClass(R.drawable.room, "single room", "Availabe"));
        roomList.add(new singleModelClass(R.drawable.room, "Apartment", "Availabe"));
    }
}
