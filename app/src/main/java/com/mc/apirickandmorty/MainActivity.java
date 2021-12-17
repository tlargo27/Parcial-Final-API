package com.mc.apirickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mc.apirickandmorty.ApiManager.RetrofitClient;
import com.mc.apirickandmorty.Models.Characters;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listCharacter;
    Characters myCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCharacter = findViewById(R.id.listCharacters);
        getFromInternetCharacters();
        listCharacter.setOnItemClickListener(this);
    }

    private void getFromInternetCharacters(){
        Call<Characters> call = RetrofitClient.getInstance().getMyApi().getCharacters();
        call.enqueue(new Callback<Characters>() {

            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                myCharacters = response.body();
                String message ="";
                CharacterAdapter adapter = new CharacterAdapter(MainActivity.this, myCharacters.getCharacterList());
                listCharacter.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent in = new Intent(this , CharacterDetail.class);
        in.putExtra("id", myCharacters.getCharacterList().get(i).getIdCharacter() );
        startActivity(in);
    }
}