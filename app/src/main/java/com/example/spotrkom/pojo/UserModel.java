package com.example.spotrkom.pojo;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int image;
    private String name;
    private int exp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public UserModel(int id, int image, String name, int exp) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.exp = exp;
    }

    @Ignore
    public UserModel(int image, String name, int exp) {
        this.image = image;
        this.name = name;
        this.exp = exp;
    }
}
