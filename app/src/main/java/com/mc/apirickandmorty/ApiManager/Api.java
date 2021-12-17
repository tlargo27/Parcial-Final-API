package com.mc.apirickandmorty.ApiManager;

import com.mc.apirickandmorty.Models.Character;
import com.mc.apirickandmorty.Models.Characters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "https://rickandmortyapi.com/api";

    @GET("character")
    Call<Characters> getCharacters();

    @GET("character/{id}")
    Call<Character> getCharacter(@Path("id") String id);


}
