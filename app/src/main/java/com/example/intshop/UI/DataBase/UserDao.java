package com.example.intshop.UI.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE login LIKE :login LIMIT 1")
    User findByLogin(String login);

    @Query("SELECT * FROM User WHERE passwd LIKE :passwd LIMIT 1")
    User findByPasswd(String passwd);

    @Query("SELECT * FROM User WHERE status LIKE :status LIMIT 1")
    User findByStatus(String status);

    @Query("INSERT INTO User(login) VALUES (:login)")
    void insertLog(String login);

    @Query("INSERT INTO User(passwd) VALUES (:passwd)")
    void insertPas(String passwd);

    @Query("INSERT INTO User(login,passwd,status) VALUES (:login,:passwd,:status)")
    public void insertData(String login, String passwd, String status);

}
