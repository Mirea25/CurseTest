package com.example.intshop.UI.DataBase;

import androidx.annotation.ColorInt;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = "login", unique = true)})
public class User {

    @PrimaryKey
    public int userId;

    @ColumnInfo(name = "login")
    public String login;

    @ColumnInfo(name = "passwd")
    public String passwd;

    @ColumnInfo(name = "status")
    public String status;
}
