package com.example.intshop.UI.Ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intshop.R;
import com.example.intshop.UI.Data.Adapters.CustomRecycleAdapter;
import com.example.intshop.UI.Data.DataStuff;

import java.util.ArrayList;
import java.util.List;
import com.example.intshop.UI.Data.Item;

public class Cp_Recycler extends AppCompatActivity {
    Integer value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_recycler);
        List<Item> itemList = new ArrayList<>();
        DataStuff.init(this);
        value = DataStuff.getIntProperty("Cp", "KEY");
        for (int i = 0; i < value; i++){
            String zxc = Integer.toString(i+1);
            itemList.add(new Item(DataStuff.getProperty("Cp", "Cp" + zxc)));
        }
        RecyclerView recyclerView = findViewById(R.id.cp_recycler);
        CustomRecycleAdapter customRecycleAdapter = new CustomRecycleAdapter(this,itemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customRecycleAdapter);
    }



    public void BackStep1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}