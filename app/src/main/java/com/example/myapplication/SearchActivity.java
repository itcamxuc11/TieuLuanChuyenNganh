package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.myapplication.model.DatabaseAccess;
import com.example.myapplication.model.Word;


public class SearchActivity extends AppCompatActivity {

    EditText edttInput;
    TextView txtType;
    TextView txtVoca;
    TextView txtVocul;
    TextView txtMean;
    TextView txtExp;
    TextView txtExam;
    TextView txtExam_trans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        edttInput = findViewById(R.id.editTextInput);
        txtVoca = findViewById(R.id.textVocabu);
        txtType = findViewById(R.id.textType);
        txtVocul = findViewById(R.id.textView5);
        txtMean = findViewById(R.id.textMean);
        txtExp =  findViewById(R.id.textExplan);
        txtExam = findViewById(R.id.textExam);
        txtExam_trans = findViewById(R.id.textExamTrans);
    }

    public void onSearch(View view){
        String input = edttInput.getText().toString();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        Word word = databaseAccess.getWord(input);
        txtVoca.setText(word.getVocabulary());
        txtType.setText(word.getType());
        txtVocul.setText(word.getVocalization());
        txtMean.setText(word.getMeaning());
        txtExp.setText(word.getExplanation());
        txtExam.setText(word.getExample());
        txtExam_trans.setText(word.getExample_translation());

    }

    public void onListen(View view){
        String input = edttInput.getText().toString().trim() + ".mp3";
        playSound(input);
    }

    private void playSound(String fileName) {
        MediaPlayer p = new MediaPlayer();
        try {
            Context ctx = this;
            AssetFileDescriptor afd = ctx.getAssets().openFd(fileName);
            p.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            p.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        p.start();
    }

}
