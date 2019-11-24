package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.myapplication.Fragment.QuestionTyprAFragment;
import com.example.myapplication.model.DatabaseAccess;
import com.example.myapplication.model.Word;

import java.util.List;
import java.util.Random;

public class LessonActivity extends AppCompatActivity {

    List<Word> list;
    int index = 0;

    String curentAnswer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String topic = bundle.getString("id", "");
            LoadData(topic);
        }
        CreateQuestion();
    }

    private void LoadData(String topic){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();;
        list = databaseAccess.GetTopic(topic);
    }


    private void CreateQuestion(){
        String question ="";
        int random1 = (int)(Math.random() * 4 + 1);
        int random2 = 0, random3 = 0, random4= 0;
        while(random2==index){
            random2 = (int)(Math.random() * 20);
        }
        while(random3 ==index || random3==random2){
            random3 = (int)(Math.random() * 20);
        }
        while(random4==index||random4==random2|random4==random3){
            random4 = (int)(Math.random() * 20);
        }
        String a="";
        String b="";
        String c="";
        String d="";

        int randomType =  (int)(Math.random() * 2 + 1);
        if(randomType==1){
            question = list.get(index).getVocabulary();
            curentAnswer = list.get(index).getMeaning();
            switch (random1){
                case 1:
                    a = list.get(index).getMeaning();
                    b = list.get(random2).getMeaning();
                    c= list.get(random3).getMeaning();
                    d = list.get(random4).getMeaning();
                    break;
                case 2:
                    b= list.get(index).getMeaning();
                    a = list.get(random2).getMeaning();
                    c= list.get(random3).getMeaning();
                    d = list.get(random4).getMeaning();
                    break;
                case 3:
                    c=list.get(index).getMeaning();
                    b = list.get(random2).getMeaning();
                    a= list.get(random3).getMeaning();
                    d = list.get(random4).getMeaning();
                    break;
                case 4:
                    d = list.get(index).getMeaning();
                    b = list.get(random2).getMeaning();
                    c= list.get(random3).getMeaning();
                    a = list.get(random4).getMeaning();
                    break;
            }
        }
        else{
            question = list.get(index).getMeaning();
            curentAnswer = list.get(index).getVocabulary();
            switch (random1){
                case 1:
                    a = list.get(index).getVocabulary();
                    b = list.get(random2).getVocabulary();
                    c= list.get(random3).getVocabulary();
                    d = list.get(random4).getVocabulary();
                    break;
                case 2:
                    b= list.get(index).getVocabulary();
                    a = list.get(random2).getVocabulary();
                    c= list.get(random3).getVocabulary();
                    d = list.get(random4).getVocabulary();
                    break;
                case 3:
                    c=list.get(index).getVocabulary();
                    b = list.get(random2).getVocabulary();
                    a= list.get(random3).getVocabulary();
                    d = list.get(random4).getVocabulary();
                    break;
                case 4:
                    d = list.get(index).getVocabulary();
                    b = list.get(random2).getVocabulary();
                    c= list.get(random3).getVocabulary();
                    a = list.get(random4).getVocabulary();
                    break;
            }
        }

        QuestionTyprAFragment fragment =(QuestionTyprAFragment) getSupportFragmentManager().findFragmentById(R.id.fragment4);
        fragment.setQuestion(question,a ,b ,c ,d);
    }

    public void onCheck(View view){
        QuestionTyprAFragment fragment =(QuestionTyprAFragment) getSupportFragmentManager().findFragmentById(R.id.fragment4);
        String answer = fragment.getAnswer();
        if(answer==curentAnswer){
            showAlertDialog("Chính xác", null);
        }
        else{
            showAlertDialog("Không chính xác", "Đáp án đúng là: " + curentAnswer);
        }
    }

    public void showAlertDialog(String title, String content){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setCancelable(false);
        builder.setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(index==19) {
                    Intent intent = new Intent(LessonActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    index++;
                    CreateQuestion();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
