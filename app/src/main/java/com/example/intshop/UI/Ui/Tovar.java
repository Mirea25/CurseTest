package com.example.intshop.UI.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intshop.R;
import com.example.intshop.UI.Data.DataStuff;
import com.example.intshop.UI.DataBase.UserDatabase;

import java.util.Objects;

public class Tovar extends AppCompatActivity {

    UserDatabase Db;
    String sample;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle text = getIntent().getExtras();
        sample = text.get("text_sample").toString();
        Log.i("CHECK", sample);
        if (sample.contains("1050")){
            setContentView(R.layout.activity_legend_ti);
        }
        else if (sample.contains("3600")){
            setContentView(R.layout.activity_ryzen3600x);
        }
        else {
            setContentView(R.layout.tovar_err);
        }

        Db = UserDatabase.getDatabase(getApplicationContext());
    }

    public void BackStepZxc(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void VKorsinu(View view){
        DataStuff.init(this);
        int count = DataStuff.getIntProperty("Korsina", "KEY");
        DataStuff.addIntProperty("Korsina", "KEY", 1 + count);
        DataStuff.addProperty("Korsina", "Korsina" + (1 + count), sample);
    }
}
