package com.example.hrestikinoliki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private EditText first_name, second_name;
private RadioButton cross, zero;
private Button start;
public static final String FIRST = "FIRST";
public static final String SECOND = "SECOND";
public static final String SIGN = "SIGN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_name = findViewById(R.id.first_name);
        second_name = findViewById(R.id.second_name);
        cross = findViewById(R.id.cross);
        zero = findViewById(R.id.zero);
        start = findViewById(R.id.start);

        start.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

            if (!first_name.getText().toString().equals("") && !second_name.getText().toString().equals("") && (cross.isChecked() || zero.isChecked())) {

                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra(FIRST, first_name.getText().toString());
                intent.putExtra(SECOND, second_name.getText().toString());
                if (zero.isChecked()) {
                    intent.putExtra(SIGN, 0);
                } else {
                    intent.putExtra(SIGN, 1);
                }
                startActivity(intent);
            }else {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            }
        }

}