package com.devjakobsen.dice.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devjakobsen.dice.Controller.DiceController;
import com.devjakobsen.dice.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button btnRoll, btnOK, btnHistory;
    EditText input;
    TextView txtRollResult;
    DiceController controller = new DiceController();
    String logTag = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up views
        btnOK = (Button) findViewById(R.id.btnOK);
        btnRoll = (Button) findViewById(R.id.btnRoll);
        input = (EditText) findViewById(R.id.input);
        txtRollResult = (TextView) findViewById(R.id.txtRollResult);
        btnHistory = (Button) findViewById(R.id.btnHistory);

        // setting up listeners
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok();
            }
        });
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history();
            }
        });
    }

    private void history() {
        Log.d(logTag, " btnHistory has been clicked");
        Intent historyActivity = new Intent(this, History.class);
        historyActivity.putExtra("map", controller.getMap());
        startActivity(historyActivity);
    }

    private void roll() {
        Log.d(logTag, " btnRoll has been clicked");
        controller.rollDices();
        displayRoll();
    }

    private void displayRoll() {
        Log.d(logTag, " displayRoll() triggered");
        if(txtRollResult.length() > 0) txtRollResult.setText("");
        String rolled = "You Rolled: ";
        for(int i: controller.getJustRolled()){
            rolled = rolled + i + " ";
        }
        txtRollResult.setText(rolled);

    }

    private void ok() {
        Log.d(logTag, " btnOK has been clicked");
        controller.addNumberOfDices(Integer.parseInt(input.getText().toString()));
        input.setText("");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("map", controller.getMap());
        outState.putIntegerArrayList("justRolled", controller.getJustRolled());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        controller.setMap((HashMap<String, ArrayList<Integer>>) savedInstanceState.getSerializable("map"));
        controller.setJustRolled(savedInstanceState.getIntegerArrayList("justRolled"));
        displayRoll();
    }
}
