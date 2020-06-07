package com.example.diet_app.bean;

import java.io.Serializable;

public class FoodBean implements Serializable{
    private String title;
    private String notmatch;
    private String desc;
    private int picId;

    public FoodBean(String title, String notmatch, String desc, int picId) {
        this.title = title;
        this.notmatch = notmatch;
        this.desc = desc;
        this.picId = picId;
    }

    public FoodBean() {
    }

    public String getTitle() {
        return title;
    }

    public String getNotmatch() {
        return notmatch;
    }

    public String getDesc() {
        return desc;
    }

    public int getPicId() {
        return picId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotmatch(String notmatch) {
        this.notmatch = notmatch;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}
