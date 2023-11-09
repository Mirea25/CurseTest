package com.example.intshop.UI.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.intshop.R;
import com.example.intshop.UI.Data.App;
import com.example.intshop.UI.DataBase.User;
import com.example.intshop.UI.DataBase.UserDatabase;

import java.util.Objects;

public class Login extends AppCompatActivity {
    private String LoginText;
    private String PasswdText;

    private boolean FLAG;
    UserDatabase Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Db = UserDatabase.getDatabase(getApplicationContext());
    }

    public void PrevButton_Login(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void getData(){
        EditText login = findViewById(R.id.login);
        EditText passwd = findViewById(R.id.passwd);

        LoginText = (login.getText()).toString();
        PasswdText = (passwd.getText()).toString();
    }

    public void LoginButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        LogLogic();
        App.setFlag(1);
        if (!FLAG) {
            startActivity(intent);
        }
    }

    public void AddAdm(View view){
        Db.userDao().insertData("abc", "zxc", "adm");
    }

    public void LogLogic(){
        FLAG = false;
        TextView text = findViewById(R.id.textView19);
        User zxc;
        getData();
        zxc = Db.userDao().findByLogin(LoginText);
        if (Objects.equals(zxc, null)) {
            Db.userDao().insertData(LoginText, PasswdText, "user");
            App.setPerms("reg");
        }
        else if (Objects.equals(zxc.status, "adm") && (Objects.equals(zxc.passwd, PasswdText))) {
            App.setPerms("adm");
        }
        else if (Objects.equals(zxc.status, "user") && (Objects.equals(zxc.passwd, PasswdText))){
            App.setPerms("user");
        }
        else {
            text.setText("Неверные данные");
            text.setTextColor(getResources().getColor(R.color.red));
            FLAG = true;
        }
    }
}