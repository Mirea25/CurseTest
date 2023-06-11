package com.example.intshop.UI.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PermsDao {

    @Query("INSERT INTO CurPerms(cur_perms) VALUES (:cur_perms)")
    void insertPermStatus(String cur_perms);

    @Query("UPDATE CurPerms SET cur_perms =:cur_perms")
    void update(String cur_perms);

    @Query("DELETE FROM CurPerms WHERE cur_perms LIKE :cur_perms")
    void delete(String cur_perms);

    @Query("SELECT * FROM CurPerms")
    String getPerm();
}
