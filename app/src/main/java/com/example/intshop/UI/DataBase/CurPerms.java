package com.example.intshop.UI.DataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CurPerms {
    @PrimaryKey
    @NonNull
    public String cur_perms;

    public CurPerms() {
        cur_perms = null;
    }
}
