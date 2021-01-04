package com.alinadangol.pre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inside_menu extends AppCompatActivity {
    private Button button4,button5,button6,button7,button9,button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_menu);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button9 = (Button) findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(inside_menu.this, inside_diet.class);
                startActivity(k);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(inside_menu.this, inside_exercises.class);
                startActivity(l);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(inside_menu.this, inside_health.class);
                startActivity(m);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(inside_menu.this, inside_beauty.class);
                startActivity(n);

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o= new Intent(inside_menu.this, inside_symptoms.class);
                startActivity(o);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p= new Intent(inside_menu.this, Music.class);
                startActivity(p);
            }
        });
    }
}
