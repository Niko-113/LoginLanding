package com.example.loginlanding.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.loginlanding.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insert(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " ORDER BY userID ASC")
    List<User> getUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE username = :username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE userID = :userID")
    User getUserByID(int userID);
}
