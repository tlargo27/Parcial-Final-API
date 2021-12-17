package com.mc.apirickandmorty.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Characters {
    @SerializedName("character")
    List<Character> characterList;

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCivilizationList(List<Character> characterList) {
        this.characterList = characterList;
    }
}
