package com.alinadangol.pre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inside_diet extends inside_menu {

    private Button first, second, third, fourth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_diet );

        first = (Button) findViewById(R.id.first);
       second = (Button) findViewById(R.id.second);
        third=(Button)findViewById(R.id.third);
        fourth=(Button)findViewById(R.id.fourth);
       first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(inside_diet.this, diet1.class);
                startActivity(z);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(inside_diet.this, diet2.class);
                startActivity(y);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(inside_diet.this, diet3.class);
                startActivity(x);
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(inside_diet.this, avoid1.class);
                startActivity(w);
            }
        });


    }
}

