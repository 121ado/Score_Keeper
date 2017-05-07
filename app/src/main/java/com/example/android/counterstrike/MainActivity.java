package com.example.android.counterstrike;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    int ctRound = 0;
    int tRound = 0;
    int ctDefus = 0;
    int tPlant = 0;
    int tWon = 0;
    int ctWon = 0;
    boolean isMatchWon = true;
    private static final String STATE_CTROUND = "stateOfCtRound";
    private static final String STATE_TROUND = "stateOfTRound";
    private static final String STATE_CTDEFUS = "stateOfCtDefus";
    private static final String STATE_TPLANT = "stateOfTPlant";
    private static final String STATE_TWON = "stateOfTWon";
    private static final String STATE_CTWON = "stateOfCtWon";
    private static final String STATE_ISMATCHWON = "stateofIsMatchWon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_CTROUND, ctRound);
        savedInstanceState.putInt(STATE_TROUND, tRound);
        savedInstanceState.putInt(STATE_CTDEFUS, ctDefus);
        savedInstanceState.putInt(STATE_TPLANT, tPlant);
        savedInstanceState.putInt(STATE_TWON, tWon);
        savedInstanceState.putInt(STATE_CTWON, ctWon);
        savedInstanceState.putBoolean(STATE_ISMATCHWON, isMatchWon);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ctRound = savedInstanceState.getInt(STATE_CTROUND);
        tRound = savedInstanceState.getInt(STATE_TROUND);
        ctDefus = savedInstanceState.getInt(STATE_CTDEFUS);
        tPlant = savedInstanceState.getInt(STATE_TPLANT);
        tWon = savedInstanceState.getInt(STATE_TWON);
        ctWon = savedInstanceState.getInt(STATE_CTWON);
        isMatchWon = savedInstanceState.getBoolean(STATE_ISMATCHWON);
        displayTR(tRound);
        displayCTR(ctRound);
        displayCTD(ctDefus);
        displayTP(tPlant);
        displayTW(tWon);
        displayCTW(ctWon);

    }

    //Methotd to + or - score
    public void addRoundsTerrorist() {
        tRound = tRound + 1;
    }

    public void addRoundsCounterTerrorist() {
        ctRound = ctRound + 1;
    }

    public void addDefus(View view) {
        if (isMatchWon) {
            if (ctRound >= 16 || tRound >= 16) {
                display();
                isMatchWon = false;
            } else {
                addRoundsCounterTerrorist();
                ctDefus = ctDefus + 1;
                displayCTD(ctDefus);
                displayCTR(ctRound);
            }
        } else {
            display();
        }
    }

    public void addCTKill(View view) {
        if (isMatchWon) {
            if (ctRound >= 16 || tRound >= 16) {
                display();
                isMatchWon = false;
            } else {
                addRoundsCounterTerrorist();
                ctWon = ctWon + 1;
                displayCTW(ctWon);
                displayCTR(ctRound);
            }
        } else {
            display();
        }
    }

    public void addPlant(View view) {
        if (isMatchWon) {
            if (ctRound >= 16 || tRound >= 16) {
                display();
                isMatchWon = false;
            } else {
                addRoundsTerrorist();
                tPlant = tPlant + 1;
                displayTP(tPlant);
                displayTR(tRound);
            }
        } else {
            display();
        }
    }

    public void addTKill(View view) {
        if (isMatchWon) {
            if (ctRound >= 16 || tRound >= 16) {
                display();
                isMatchWon = false;
            } else {
                addRoundsTerrorist();
                tWon = tWon + 1;
                displayTW(tWon);
                displayTR(tRound);
            }
        } else {
            display();
        }
    }

    //Methods to display scores and text.
    public void displayTR(int tRound) {
        TextView TerroristsTextView = (TextView) findViewById(R.id.t_points);
        TerroristsTextView.setText(String.valueOf(tRound));
    }

    public void displayCTR(int ctRound) {
        TextView CTerroristsTextView = (TextView) findViewById(R.id.ct_points);
        CTerroristsTextView.setText(String.valueOf(ctRound));
    }

    public void displayCTD(int ctDefus) {
        TextView DefusTextView = (TextView) findViewById(R.id.defus);
        DefusTextView.setText(String.valueOf(ctDefus));
    }

    public void displayTP(int tPlant) {
        TextView TerroristsPlantTextView = (TextView) findViewById(R.id.plant);
        TerroristsPlantTextView.setText(String.valueOf(tPlant));
    }

    public void displayTW(int tWon) {
        TextView TerroristsWonTextView = (TextView) findViewById(R.id.t_Kill);
        TerroristsWonTextView.setText(String.valueOf(tWon));
    }

    public void displayCTW(int ctWon) {
        TextView CTerroristsWonTextView = (TextView) findViewById(R.id.ct_Kill);
        CTerroristsWonTextView.setText(String.valueOf(ctWon));
    }

    public void display() {
        TextView TopTextView = (TextView) findViewById(R.id.top_info);
        TopTextView.setText(String.valueOf(getString(R.string.scoreEdit)));
    }

    public void displayR() {
        TextView TopRTextView = (TextView) findViewById(R.id.top_info);
        TopRTextView.setText(String.valueOf(getString(R.string.score)));
    }


    //Method to reset all values
    public void resetButton(View view) {
        ctRound = 0;
        tRound = 0;
        ctDefus = 0;
        tPlant = 0;
        tWon = 0;
        ctWon = 0;
        isMatchWon = true;
        displayTR(tRound);
        displayCTR(ctRound);
        displayCTD(ctDefus);
        displayTP(tPlant);
        displayTW(tWon);
        displayCTW(ctWon);
        displayR();
    }
}
