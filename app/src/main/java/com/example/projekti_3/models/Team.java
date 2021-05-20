package com.example.projekti_3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Team implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("realname")
    @Expose
    private String realname;

    @SerializedName("team")
    @Expose
    private String team;

    @SerializedName("imageurl")
    @Expose
    private String imageurl;

    @SerializedName("bio")
    @Expose
    private String bio;


    @SerializedName("firstappearance")
    @Expose
    private String firstappearance;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }
}
