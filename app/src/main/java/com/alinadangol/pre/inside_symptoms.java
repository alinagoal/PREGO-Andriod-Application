package com.alinadangol.pre;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class inside_symptoms extends AppCompatActivity {
DatabaseHelper myDB;
 Button clear1, save1;
EditText memo;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    ImageButton mVoiceBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_symptoms);
        memo= findViewById(R.id.memo);
        clear1 = findViewById(R.id.clear1);
        save1= findViewById(R.id.save1);

//        mTextTv=findViewById(R.id.textTv);
        mVoiceBtn=findViewById(R.id.voiceBtn);

        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();

            }
        });

        myDB= new DatabaseHelper(this);
        clear1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String newEntry=memo.getText().toString();
                if( memo.length()!=0){
                    AddData(newEntry);
                    memo.setText("");
                }else{
                    Toast.makeText(inside_symptoms.this,"You must put something in the text field",Toast.LENGTH_LONG).show();
                }
            }
        });
        save1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new Intent( inside_symptoms.this,ViewListContents.class);
                startActivity(intent);
            }
        });

    }


    private void speak() {

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT," Hi Speak Something");


        try{
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
        }
        catch(Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if(resultCode==RESULT_OK && null!=data){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    memo.setText(result.get(0));
                }
                break;
            }
        }
    }


    public void AddData(String newEntry){
        boolean insertData=myDB.addData(newEntry);
        if (insertData==true){
            Toast.makeText(inside_symptoms.this,"Successfully inserted data",Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(inside_symptoms.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}

//