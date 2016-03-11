package com.devjakobsen.dice.Controller;

import android.util.Log;

import com.devjakobsen.dice.Model.Dice;

import java.util.ArrayList;

/**
 * Created by Jakobsen. K on 01-03-2016.
 */
public class DiceFactory {
    private String logTag = "Controller/DiceFactory";

    public ArrayList<Dice> createDices(int i) {
        ArrayList<Dice> list = new ArrayList<>();
        for (int x = 0; x < i; x++) {

            list.add(new Dice());
        }
        Log.d(logTag, "/createDices()/ " + list.size() + " dices has been added");
        return list;
    }
}
