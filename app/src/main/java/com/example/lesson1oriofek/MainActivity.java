package com.example.lesson1oriofek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float summry;
    float lastSummery;
    boolean thereIsSummery;
    Intent si;
    final int ADD = 1;
    final int SUB = 2;
    final int MUltiply = 3;
    final int DIVIDE = 4;
    EditText display;
    int flag; // 1- add 2-sub 3- malitpation 4- divide
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (EditText)findViewById(R.id.display);
        str = "";
        flag = ADD;
        thereIsSummery = false;
    }

    public void add(View view)
    {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setHint("");
            display.setSelection(display.getText().length());
            flag = ADD;
        }
    }

    public void sub(View view) {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setHint("");
            display.setSelection(display.getText().length());
            flag = SUB;
        }
    }

    public void multiplication(View view) {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setHint("");
            display.setSelection(display.getText().length());
            flag = MUltiply;
        }
    }

    public void divide(View view) {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setHint("");
            display.setSelection(display.getText().length());
            flag = DIVIDE;
        }
    }

    public void reset(View view) {
        str = "";
        summry = 0;
        display.setText(str);
        display.setSelection(display.getText().length());
        flag = ADD;
        display.setHint("");
    }

    public void showSummery(View view) {
        if ((!display.getText().toString().equals("")))
        {
            if(setSummry(Float.valueOf((display.getText().toString()))))
            {
                if((((float)((int)summry)) == (float)summry))
                {
                    display.setText(String.valueOf((int)summry));
                }
                else
                {
                    display.setText(String.valueOf(summry));
                }
                display.setHint("");
                lastSummery = summry;
                thereIsSummery = true;
            }
            summry = 0;
            str = "";
            flag = ADD;
        }
    }

    public boolean setSummry(float num)
    {
        if (flag == ADD)
        {
            summry +=num;
        }
        else if (flag == SUB)
        {
            summry -= num;
        }
        else if (flag == MUltiply)
        {
            summry *= num;
        }
        else
        {
            if(num == 0)
            {
                display.setText("");
                display.setHint("Albert don't try to fail my app");
                return false;
            }
            else {
                summry /= num;
            }
        }
        return true;
    }

    public void credits(View view) {
        Intent si = new Intent(this,credits.class);
        si.putExtra("lastSummery",lastSummery);
        si.putExtra("isSummery",thereIsSummery);
        startActivity(si);
    }
}