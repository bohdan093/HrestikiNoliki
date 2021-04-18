package com.example.hrestikinoliki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
private TextView first_score, second_score;
private Button reset, one, two, three, four, five, six, seven, eight, nine;
private Intent intent;
private int sign = 0, local_sign=0, score_first=0, score_second = 0, counter =0;
private String s = "";
private  String sign_winer;
private String oneS, twoS, threeS, fourS, fiveS, sixS, sevenS, eightS, nineS;
private SharedPreferences preferences;
private final String SCORE_F = "SCORE_F";
private final String SCORE_S = "SCORE_S";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        first_score = findViewById(R.id.first_score);
        second_score = findViewById(R.id.second_score);
        reset = findViewById(R.id.reset);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        intent = getIntent();
        sign = intent.getIntExtra(MainActivity.SIGN, 0);

        local_sign = sign;
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        reset.setOnClickListener(this);


     // values
     if(sign == 0){
         sign_winer = "O";
     }else {
         sign_winer = "X";
     }

     getInformation(score_first, score_second);
    }


    public void getInformation(int first, int second){
        first_score.setText(intent.getStringExtra(MainActivity.FIRST)+ ": " +String.valueOf(first));
        second_score.setText(intent.getStringExtra(MainActivity.SECOND)+ ": " +String.valueOf(second));
    }

    public void checkSign(){
        if(local_sign == 0) {
            s = "O";
            local_sign = 1;
        }else {
            s = "X";
            local_sign = 0;
        }
    }


    @Override
    public void onClick(View v) {

        checkSign();

        switch(v.getId()){
            case R.id.one:{
                if(one.getText().toString().equals("")) {
                    one.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.two:{
                if(two.getText().toString().equals("")) {
                    two.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.three:{
                if(three.getText().toString().equals("")) {
                    three.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.four:{
                if(four.getText().toString().equals("")) {
                    four.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.five:{
                if(five.getText().toString().equals("")) {
                    five.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.six:{
                if(six.getText().toString().equals("")) {
                    six.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.seven:{
                if(seven.getText().toString().equals("")) {
                    seven.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.eight:{
                if(eight.getText().toString().equals("")) {
                    eight.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.nine:{
                if(nine.getText().toString().equals("")) {
                    nine.setText(s);
                    counter++;
                }
                break;
            }

            case R.id.reset:{
                score_first =0;
                score_second =0;
                one.setText("");
               clear_buttons();
                counter=0;
                getInformation(score_first, score_second);

                break;
            }

        }



            logic();



    }

public void clear_buttons(){
    one.setText("");
    two.setText("");
    three.setText("");
    four.setText("");
    five.setText("");
    six.setText("");
    seven.setText("");
    eight.setText("");
    nine.setText("");
    counter =0;
}
    public void logic()  {
        oneS = one.getText().toString();
        twoS = two.getText().toString();
        threeS = three.getText().toString();
        fourS = four.getText().toString();
        fiveS = five.getText().toString();
        sixS = six.getText().toString();
        sevenS = seven.getText().toString();
        eightS = eight.getText().toString();
        nineS = nine.getText().toString();
        String sign = "";
        //for X
        if(oneS.equals("X") && twoS.equals("X") && threeS.equals("X")){
            sign = "X";
        }
        if(fourS.equals("X") && fiveS.equals("X") && sixS.equals("X")){
            sign = "X";
        }
        if(sevenS.equals("X") && eightS.equals("X") && nineS.equals("X")){
            sign = "X";
        }
        if(oneS.equals("X") && fourS.equals("X") && sevenS.equals("X")){
            sign = "X";
        }
        if(twoS.equals("X") && fiveS.equals("X") && eightS.equals("X")){
            sign = "X";
        }
        if(threeS.equals("X") && sixS.equals("X") && nineS.equals("X")){
            sign = "X";
        }
        if(oneS.equals("X") && fiveS.equals("X") && nineS.equals("X")){
            sign = "X";
        }
        if(threeS.equals("X") && fiveS.equals("X") && sevenS.equals("X")){
            sign = "X";
        }
        //for O
        if(oneS.equals("O") && twoS.equals("O") && threeS.equals("O")){
            sign = "O";
        }
        if(fourS.equals("O") && fiveS.equals("O") && sixS.equals("O")){
            sign = "O";
        }
        if(sevenS.equals("O") && eightS.equals("O") && nineS.equals("O")){
            sign = "O";
        }
        if(oneS.equals("O") && fourS.equals("O") && sevenS.equals("O")){
            sign = "O";
        }
        if(twoS.equals("O") && fiveS.equals("O") && eightS.equals("O")){
            sign = "O";
        }
        if(threeS.equals("O") && sixS.equals("O") && nineS.equals("O")){
            sign = "O";
        }
        if(oneS.equals("O") && fiveS.equals("O") && nineS.equals("O")){
            sign = "O";
        }
        if(threeS.equals("O") && fiveS.equals("O") && sevenS.equals("O")){
            sign = "O";
        }

        if(sign.equals(sign_winer)){
            Toast.makeText(this, "The first player won "+ '\n'+" Congratulations!", Toast.LENGTH_LONG).show();
            getInformation(++score_first, score_second);
            sign= "";
            clear_buttons();
        }else if(sign.equals("O") || sign.equals("X")){
            Toast.makeText(this, "The second player won+ \n Congratulations!", Toast.LENGTH_LONG).show();
            getInformation(score_first, ++score_second);
            sign = "";
            clear_buttons();
        }
        if(counter == 9 && sign.equals("")){
            Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
            clear_buttons();
        }
    }

    public void save(){
        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(SCORE_F, score_first);
        editor.putInt(SCORE_S, score_second);
        editor.apply();
    }

    public void load(){
        preferences = getPreferences(MODE_PRIVATE);
        int score_f = preferences.getInt(SCORE_F, 0);
        int score_s = preferences.getInt(SCORE_S, 0);
        score_second =score_s;
        score_first =score_f;
        getInformation(score_f, score_s);
    }

    @Override
    protected void onStop() {
        super.onStop();
        save();
    }

    @Override
    protected void onStart() {
        super.onStart();
        load();
    }
}