package com.example.intshop.UI.Ui;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intshop.R;
import com.example.intshop.UI.Data.Adapters.CustomRecycleAdapter;
import com.example.intshop.UI.Data.DataStuff;
import com.example.intshop.UI.Data.Item;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Etc_Recycler extends AppCompatActivity {
    Integer value;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_etc_recycler);
         List<Item> itemList = new ArrayList<>();
         DataStuff.init(this);
         value = DataStuff.getIntProperty("Etc", "KEY");
         for (int i = 0; i < value; i++) {
             String zxc = Integer.toString(i+1);
             itemList.add(new Item(DataStuff.getProperty("Etc", "Etc" + zxc)));
         }
         RecyclerView recyclerView = findViewById(R.id.etc_recycler);
         CustomRecycleAdapter customRecycleAdapter = new CustomRecycleAdapter(this, itemList);
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(linearLayoutManager);
         recyclerView.setAdapter(customRecycleAdapter);
        }

    public void BackStep2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}