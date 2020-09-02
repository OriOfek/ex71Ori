package com.example.lesson1oriofek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    Intent gi;
    TextView tv;
    float last_summery;
    Intent si;
    boolean there_is_summery;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        gi = getIntent();
        tv = (TextView) findViewById(R.id.answer);
        last_summery = gi.getFloatExtra("lastSummery",1);
        there_is_summery = gi.getBooleanExtra("isSummery",false);

        if(there_is_summery)
        {
            tv.setText("the last calculate = "+String.valueOf(last_summery));
        }
        else
        {
            tv.setText("U did'nt use my app");
        }
    }

    public void backToTheActivity(View view) {
        Intent si = new Intent(this,MainActivity.class);
        startActivity(si);
    }
}