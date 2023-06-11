package com.example.intshop.UI.Ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intshop.R;
import com.example.intshop.UI.Data.Adapters.CustomRecycleAdapter;
import com.example.intshop.UI.Data.Adapters.KorsinaRecycleAdapter;
import com.example.intshop.UI.Data.DataStuff;
import com.example.intshop.UI.Data.Item;

import java.util.ArrayList;
import java.util.List;

public class Korsina extends AppCompatActivity {

    Integer value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korsina);
        List<Item> itemList = new ArrayList<>();
        DataStuff.init(this);
        value = DataStuff.getIntProperty("Korsina", "KEY");
        for (int i = 0; i < value; i++){
            String zxc = Integer.toString(i+1);
            itemList.add(new Item(DataStuff.getProperty("Korsina", "Korsina" + zxc)));
        }

        Log.i("DATA", itemList.get(0).getText());
        Log.i("DATA2", itemList.get(1).getText());

        RecyclerView recyclerView = findViewById(R.id.korsina_recycler);
        KorsinaRecycleAdapter korsinaRecycleAdapter = new KorsinaRecycleAdapter(this, itemList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(korsinaRecycleAdapter);
    }

    public void NeverGonnaGiveYouUp(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        startActivity(intent);
    }

    public void BackStepLK(View view){
        Intent intent = new Intent(this, LK.class);
        startActivity(intent);
    }
}