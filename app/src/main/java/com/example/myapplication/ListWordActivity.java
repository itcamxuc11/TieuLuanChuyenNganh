package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.adapter.WordAdapter;
import com.example.myapplication.model.DatabaseAccess;
import com.example.myapplication.model.Word;

import java.util.List;

public class ListWordActivity extends AppCompatActivity {
    ListView lavWord;
    WordAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_word);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String topic = bundle.getString("id", "");
            LoadData(topic);
        }
    }


    private void LoadData(String topic){
        lavWord = findViewById(R.id.listWord);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();;
        List<Word> list = databaseAccess.GetTopic(topic);
        Log.e(topic, String.valueOf(list.size()));
        //adapter = new WordAdapter(this, R.layout.word_item, list);
        //ArrayAdapter adapter = new ArrayAdapter(ListWordActivity.this,list);
        lavWord.setAdapter(adapter);
    }
}
