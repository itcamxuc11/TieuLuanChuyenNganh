package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Topic;
import com.example.myapplication.model.Word;

import java.util.List;

public class WordAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Word> list;

    public WordAdapter(Context context, int layout, List<Word> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        convertView = layoutInflater.inflate(layout, null);
        TextView txtWord = convertView.findViewById(R.id.word_item);
        final ImageButton btnRemeber = convertView.findViewById(R.id.remeber);
        final Word word = list.get(position);
        txtWord.setText(word.getVocabulary());
        if(word.getStatus().equals("5")) btnRemeber.setImageResource(R.drawable.star_gold);
        else btnRemeber.setImageResource(R.drawable.star_white);
        btnRemeber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(word.getStatus().equals("5")) {
                    btnRemeber.setImageResource(R.drawable.star_white);
                }
                else {
                    btnRemeber.setImageResource(R.drawable.star_gold);
                }
            }
        });
        return convertView;
    }
}
