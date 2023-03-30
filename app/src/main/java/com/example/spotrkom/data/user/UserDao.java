package com.example.spotrkom.data.user;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.spotrkom.pojo.UserModel;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user ORDER BY exp DESC")
    LiveData<List<UserModel>> getAllUsers();

    @Query("DELETE FROM user")
    void deleteAllUsers();

    @Update
    void updateUser(UserModel user);

    @Delete
    void deleteUser(UserModel user);

    @Insert
    void insertUser(UserModel user);

}
