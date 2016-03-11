package com.devjakobsen.dice.View;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devjakobsen.dice.Controller.HistoryController;
import com.devjakobsen.dice.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jakobsen. K on 02-03-2016.
 */
public class History extends ListActivity {


    ListView listHistory;
    HistoryController historyController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        listHistory = (ListView) findViewById(android.R.id.list);
        historyController = new HistoryController();
        displayHistory();

    }

    private void displayHistory() {
        Intent data = getIntent();
        HashMap<String, ArrayList<Integer>> map = (HashMap<String, ArrayList<Integer>>) data.getSerializableExtra("map");
        ArrayList<String> stringArray = historyController.convertToStringArray(map);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArray);
        listHistory.setAdapter(adapter);

    }

}
