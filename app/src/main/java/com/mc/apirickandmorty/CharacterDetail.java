package com.mc.apirickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.mc.apirickandmorty.ApiManager.RetrofitClient;
import com.mc.apirickandmorty.Models.Character;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetail extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        Bundle in = getIntent().getExtras();
        id = in.getString("id");
    }

    private void getCharacterById(String id ) {
        Call<Character> call = RetrofitClient.getInstance().getMyApi().getCharacter(id);
        call.enqueue(new Callback<Character>() {

            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character myCharacter = response.body();
                Toast.makeText(getApplicationContext(), myCharacter.getNameCharacter(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}