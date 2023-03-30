package com.example.spotrkom.pojo;

public class RanksModel {

    private int indicatorColor;
    private String nameRank;
    private String points;

    public RanksModel(int indicatorColor, String nameRank, String points) {
        this.indicatorColor = indicatorColor;
        this.nameRank = nameRank;
        this.points = points;
    }

    public int getIndicatorColor() {
        return indicatorColor;
    }

    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
    }

    public String getNameRank() {
        return nameRank;
    }

    public void setNameRank(String nameRank) {
        this.nameRank = nameRank;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
