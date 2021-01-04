package com.alinadangol.pre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inside_exercises extends AppCompatActivity {
    private Button button8, button10, button11, button12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_exercises  );

        button8 = (Button) findViewById(R.id.button8);
        button10 = (Button) findViewById(R.id.button10);
        button11=(Button)findViewById(R.id.button11);
        button12=(Button)findViewById(R.id.button12);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(inside_exercises.this, first_trimester.class);
                startActivity(z);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(inside_exercises.this, second_trimester.class);
                startActivity(y);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(inside_exercises.this, third_semester.class);
                startActivity(x);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(inside_exercises.this, avoid.class);
                startActivity(w);
            }
        });


    }
}



