package com.example.lesson1oriofek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float summry;
    EditText display;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (EditText)findViewById(R.id.display);
    }

    public void add(View view) {
        str = display.getText().toString();
        str += '+';
        display.setText(str);
        display.setSelection(display.getText().length());
    }

    public void sub(View view) {
        str = display.getText().toString();
        str += '-';
        display.setText(str);
        display.setSelection(display.getText().length());
    }

    public void multiplication(View view) {
        str = display.getText().toString();
        str += 'X';
        display.setText(str);
        display.setSelection(display.getText().length());
    }

    public void divide(View view) {
        str = display.getText().toString();
        str += ':';
        display.setText(str);
        display.setSelection(display.getText().length());
    }

    public void reset(View view) {
        str = "";
        display.setText(str);
        display.setSelection(display.getText().length());
    }

    public void showSummery(View view) {
    }
}