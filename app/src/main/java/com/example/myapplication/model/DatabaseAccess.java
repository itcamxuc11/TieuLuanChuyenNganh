package com.example.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseAccess {
    private SQLiteAssetHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static  DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return  instance;
    }

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
        if(this.db != null) this.db.close();
    }

    public  List<Topic> GetAllTopics(){
        c = db.rawQuery("SELECT * from Topics",new String[]{} );
        List<Topic> list = new ArrayList<>();
        while(c.moveToNext()){
            String id = String.valueOf(c.getInt(0));
            String name = c.getString(1);
            list.add(new Topic(id,name));
        }
        return list;
    }

    public List<Word> GetTopic(String topic){
        c = db.rawQuery("SELECT * from Words WHERE Topic =" + topic,new String[]{} );
        List<Word> list = new ArrayList<>();
        while(c.moveToNext()){
            Word word = new Word();
            String id = String.valueOf(c.getInt(0));
            String vocabulary = c.getString(1);
            String meaning = c.getString(4);
            String status = c.getString(8);
            word.setId(id);
            word.setVocabulary(vocabulary);
            word.setMeaning(meaning);
            word.setStatus(status);
            list.add(word);
        }
        return list;
    }

    public void SaveDate(String id){
        ContentValues contentValues = new ContentValues();
        Date date= new Date();
        contentValues.put("Date",date.getTime());
        db.update("Topics", contentValues, "ID" + "=" + id, null);
        Log.e(id,String.valueOf(date.getTime()));
    }

    public String getLastLearnedTopic(){
        c = db.rawQuery("SELECT * from Topics ORDER BY Date DESC",new String[]{} );
        List<Topic> list = new ArrayList<>();
        if (c.moveToNext()){
            String id = String.valueOf(c.getInt(0));
            return id;
        }
        return null;
    }

    public  Word getWord(String input){
        c = db.rawQuery("SELECT * from Words WHERE Vocabulary = '" + input + "'",new String[]{} );
        Word word = new Word();
        while(c.moveToNext()){
            String id = String.valueOf(c.getInt(0));
            String vocabulary = c.getString(1);
            String type = c.getString(2);
            String voc = c.getString(3);
            String meaning = c.getString(4);
            String explan = c.getString(5);
            String exam = c.getString(6);
            String exam_tran = c.getString(7);
            String status = c.getString(8);
            word.setId(id);
            word.setVocabulary(vocabulary);
            word.setMeaning(meaning);
            word.setType(type);
            word.setVocalization(voc);
            word.setExplanation(explan);
            word.setExample(exam);
            word.setExample_translation(exam_tran);
            word.setStatus(status);
        }
        return word;
    }


}
