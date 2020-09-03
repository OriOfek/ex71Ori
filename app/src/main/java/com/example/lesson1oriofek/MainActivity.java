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
    EditText display;
    int flag; // 1- add 2-sub 3- malitpation 4- divide
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (EditText)findViewById(R.id.display);
        str = "";
        flag = 1;
        thereIsSummery = false;
    }

    public void add(View view)
    {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setSelection(display.getText().length());
            flag = 1;
        }
    }

    public void sub(View view) {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setSelection(display.getText().length());
            flag = 2;
        }
    }

    public void multiplication(View view) {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setSelection(display.getText().length());
            flag = 3;
        }
    }

    public void divide(View view) {
        if (!(display.getText().toString().equals("")))
        {
            setSummry(Float.valueOf((display.getText().toString())));
            str += display.getText().toString();
            display.setText("");
            display.setSelection(display.getText().length());
            flag = 4;
        }
    }

    public void reset(View view) {
        str = "";
        summry = 0;
        display.setText(str);
        display.setSelection(display.getText().length());
        flag = 1;
        display.setHint("");
    }

    public void showSummery(View view) {
        if ((!display.getText().toString().equals("")))
        {
            if(setSummry(Float.valueOf((display.getText().toString()))))
            {
                if((((float)((int)summry)) == (float)summry))
                {
                    lastSummery = (int)summry;
                    display.setText(String.valueOf((int)summry));
                }
                else
                {
                    lastSummery = summry;
                    display.setText(String.valueOf(summry));
                }
                display.setSelection(display.getText().length());
                display.setHint("");
                thereIsSummery = true;
            }
            summry = 0;
            str = "";
            flag = 1;
        }
    }

    public boolean setSummry(float num)
    {
        if (flag == 1)
        {
            summry +=num;
        }
        else if (flag == 2)
        {
            summry -= num;
        }
        else if (flag == 3)
        {
            summry *= num;
        }
        else
        {
            if(num == 0)
            {
                display.setText("");
                display.setHint("Albert do'nt fail me");
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