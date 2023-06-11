package com.example.intshop.UI.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intshop.R;
import com.example.intshop.UI.Data.DataStuff;
import com.example.intshop.UI.DataBase.UserDatabase;

import java.util.Objects;

public class LK extends AppCompatActivity {
    UserDatabase Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Db = UserDatabase.getDatabase(getApplicationContext());
        if (Objects.equals(Db.permsDao().getPerm(), "adm")){
            setContentView(R.layout.admin_lk);
        }
        else {
            setContentView(R.layout.activity_lk);
            ImageView image = findViewById(R.id.imageView2);
            image.setImageResource(R.mipmap.ava);
        }
    }

    public void Tovary_Btn(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Login_Button(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void BackStepBtn(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Korsina(View view){
        Intent intent = new Intent(this, Korsina.class);
        startActivity(intent);
    }

    public void AddVideo(View view) {
        EditText video = findViewById(R.id.VideoEdit);
        String Name = String.valueOf(video.getText());
        DataStuff.init(this);
        int count = DataStuff.getIntProperty("Video", "KEY");
        DataStuff.addIntProperty("Video", "KEY", 1 + count);
        DataStuff.addProperty("Video", "Video" + (1 + count), Name);
    }

    public void AddCp(View view){
        EditText Cp = findViewById(R.id.CpEdit);
        String Name = String.valueOf(Cp.getText());
        DataStuff.init(this);
        int count = DataStuff.getIntProperty("Cp", "KEY");
        DataStuff.addIntProperty("Cp", "KEY", 1 + count);
        DataStuff.addProperty("Cp", "Cp" + (1 + count), Name);
    }

    public void AddEtc(View view){
        EditText Etc = findViewById(R.id.EtcEdit);
        String Name = String.valueOf(Etc.getText());
        DataStuff.init(this);
        int count = DataStuff.getIntProperty("Etc", "KEY");
        DataStuff.addIntProperty("Etc", "KEY", 1 + count);
        DataStuff.addProperty("Etc", "Etc" + (1 + count), Name);
    }

    public void DeleteAll(View view){
        DataStuff.Delete("Video");
        DataStuff.Delete("Cp");
        DataStuff.Delete("Etc");
    }

    public void Back_Step(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}