package com.mc.apirickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mc.apirickandmorty.Models.Character;

import java.util.List;

public class CharacterAdapter extends BaseAdapter {
    protected Activity activity;
    protected List<Character> myCharacters;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_item);
    }*/

    public CharacterAdapter(Activity activity, List<Character> myCharacters) {
        this.activity = activity;
        this.myCharacters = myCharacters;
    }

    @Override
    public int getCount() {
        return myCharacters.size();
    }

    @Override
    public Object getItem(int i) {
        return myCharacters.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.character_item, null);
        }
        Character character = myCharacters.get(i);
        TextView nameCharacter = v.findViewById(R.id.tvName);
        nameCharacter.setText(character.getNameCharacter());

        TextView idCharacter = v.findViewById(R.id.tvId);
        idCharacter.setText(character.getIdCharacter());

        return v;
    }
}