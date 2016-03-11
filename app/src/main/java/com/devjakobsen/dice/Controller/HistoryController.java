package com.devjakobsen.dice.Controller;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jakobsen. K on 02-03-2016.
 */
public class HistoryController {


    public ArrayList<String> convertToStringArray(HashMap<String, ArrayList<Integer>> map) {
        ArrayList<String> stringArray = new ArrayList<>();
        String OMGTOMANYLOOOPS = "";
        for(Map.Entry<String, ArrayList<Integer>> data : map.entrySet()){
            OMGTOMANYLOOOPS = data.getKey() + " - ";
            Log.d("ash", OMGTOMANYLOOOPS);
            for(int i : data.getValue()){
                OMGTOMANYLOOOPS = OMGTOMANYLOOOPS + i + " ";
                Log.d("ash", OMGTOMANYLOOOPS);
            }
            stringArray.add(OMGTOMANYLOOOPS);

        }
        Collections.sort(stringArray);
        Collections.reverse(stringArray);
        return stringArray;
    }
}
