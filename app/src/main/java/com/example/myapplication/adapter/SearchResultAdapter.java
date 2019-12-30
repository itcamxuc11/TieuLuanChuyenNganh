package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Word;

import java.util.List;

public class SearchResultAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Word> list;
    TextToSpeech textToSpeech;
    public SearchResultAdapter(Context context, int layout, List<Word> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        Log.e("aaa", String.valueOf(list.size()));
        /*textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });
        */
    }

    @Override
    public int getCount() {
        return list.size();
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

        TextView txtVoca = convertView.findViewById(R.id.textVocabu);
        TextView txtType = convertView.findViewById(R.id.textType);
        TextView txtVol = convertView.findViewById(R.id.textVol);
        TextView txtMean = convertView.findViewById(R.id.textMean);
        TextView txtExplane = convertView.findViewById(R.id.textExplan);
        TextView txtExam = convertView.findViewById(R.id.textExam);
        TextView txtExamTrans = convertView.findViewById(R.id.textExamTrans);
        ImageButton btnSpeaker = convertView.findViewById(R.id.imageButtonSpeak);
        final Word word = list.get(position);

        txtVoca.setText(word.getVocabulary());
        txtType.setText(word.getType());
        txtVol.setText(word.getVocalization());
        txtExplane.setText(word.getExplanation());
        txtMean.setText(word.getMeaning());
        txtExam.setText(word.getExample());
        txtExamTrans.setText(word.getExample_translation());

        btnSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(word.getVocabulary()+".mp3");
            }
        });
        return  convertView;
    }

    private void playSound(String fileName) {
        MediaPlayer p = new MediaPlayer();
        try {
            Context ctx = context;
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
