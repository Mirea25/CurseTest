
package com.example.intshop.UI.Ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.intshop.R;
import com.example.intshop.UI.Data.App;
import com.example.intshop.UI.Data.DataStuff;
import com.example.intshop.UI.DataBase.CurPerms;
import com.example.intshop.UI.DataBase.UserDatabase;
import com.example.intshop.UI.Ui.Login;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String status;

    UserDatabase Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent1 = new Intent(this, Login.class);
        Intent intent2 = new Intent(this, LK.class);
        Db = UserDatabase.getDatabase(getApplicationContext());
        if (App.getFlag() != null) {
            Checker();
        }
        Log.i("MAIN_INSTANCE", String.valueOf(App.getInstance()));
        Button zxc = findViewById(R.id.button10);
        zxc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(Db.permsDao().getPerm(), "unknown")) {
                    startActivity(intent1);
                }
                else {
                    startActivity(intent2);
                }
            }
        });
    }
    public void Authorisation(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void VideoCards(View view) {
        Intent intent = new Intent(this, Video_Recycler.class);
        startActivity(intent);
    }

    public void Cp(View view) {
        Intent intent = new Intent(this, Cp_Recycler.class);
        startActivity(intent);
    }

    public void Etc(View view) {
        Intent intent = new Intent(this, Etc_Recycler.class);
        startActivity(intent);
    }

    public void OffSite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://online-edu.mirea.ru"));
        startActivity(intent);
    }

    private void Checker(){
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView1 = findViewById(R.id.textView1);

        status = Db.permsDao().getPerm();
        Log.i("PERM_VAL", status);
            switch (status) {
                case "adm":
                    textView2.setText("Администратор");
                    textView1.setText("");
                    break;
                case "reg":
                    textView2.setText("Новый пользователь");
                    break;
                case "user":
                    textView2.setText("Снова");
                    textView2.setTextColor(getResources().getColor(R.color.sup2ch));
                    textView1.setTextColor(getResources().getColor(R.color.sup2ch));
                    break;
            }
        }
}