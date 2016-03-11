package com.devjakobsen.dice.Controller;

import android.util.Log;

import com.devjakobsen.dice.Model.Dice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by Jakobsen. K on 01-03-2016.
 */
public class DiceController {

    private String logTag = "Controller/DiceController";
    private ArrayList<Dice> list;
    private HashMap<String, ArrayList<Integer>> map;
    private ArrayList<Integer> justRolled;

    public DiceController()
    {
        list = new ArrayList<>();
        map = new HashMap<>();
        justRolled = new ArrayList<>();
    }

    public void addNumberOfDices(int i) {
        DiceFactory diceFactory = new DiceFactory();
        list = diceFactory.createDices(i);
        Log.d(logTag, "/addNumberOfDices()/ " + list.size() + " dices in list");
    }

    // adding the rolled number to each dice
    public void rollDices()    {
        Random random = new Random();
        if(justRolled.size() > 0 ) justRolled.clear(); // should only save the rolled result
        for (Dice dice:list) {
            int rolledNumber = random.nextInt(6)+1;
            dice.history.add(rolledNumber);
            Log.d(logTag, "/rollDices()/ " + rolledNumber + " to Dice history");
            justRolled.add(rolledNumber);
        }
        addToMainHistory();

    }

    // adding date and last throw(all dices) in a history - maybe it should have been in the historyController
    private void addToMainHistory() {
        ArrayList<Integer> intArray = new ArrayList<>();
        for(Dice dice : list)
        {
            int lastIndex = dice.history.size()-1;
            int rolledNumber = dice.history.get(lastIndex);
            intArray.add(rolledNumber);
        }
        map.put(getDate(), intArray);
        Log.d(logTag, "/addToHistory()/ Date and intArray Added to hashmap");
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = sdf.format(date);
        Log.d(logTag, "/getDate()/ Date formated");
        return formattedDate;
    }

    public HashMap<String, ArrayList<Integer>> getMap(){
        return map;
    }

    public void setMap(HashMap<String, ArrayList<Integer>> map){
        this.map = map;
    }

    public void setJustRolled(ArrayList<Integer> justRolled){
        this.justRolled = justRolled;
    }
    public ArrayList<Integer> getJustRolled()
    {
        return justRolled;
    }


}
