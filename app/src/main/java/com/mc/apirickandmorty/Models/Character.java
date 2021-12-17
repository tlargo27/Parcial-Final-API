package com.mc.apirickandmorty.Models;


import com.google.gson.annotations.SerializedName;

public class Character {
    @SerializedName("id")
    private String idCharacter;

    @SerializedName("name")
    private  String nameCharacter;

    public String getIdCharacter() {
        return idCharacter;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public void setIdCharacter(String idCharacter) {
        this.idCharacter = idCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }
}
