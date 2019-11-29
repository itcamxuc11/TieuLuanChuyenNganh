package com.example.myapplication.Fragment;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.DatabaseAccess;
import com.example.myapplication.model.Word;

public class FragmentSearchActivity extends Fragment {

    EditText edttInput;
    TextView txtType;
    TextView txtVoca;
    TextView txtVocul;
    TextView txtMean;
    TextView txtExp;
    TextView txtExam;
    TextView txtExam_trans;
    ImageButton btnSearch;
    ImageButton btnSpeak;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
<<<<<<< HEAD
        return inflater.inflate(R.layout.activity_search,container,false);

=======
        View view =  inflater.inflate(R.layout.fragment_search,container,false);
        edttInput = view.findViewById(R.id.editTextInput);
        txtVoca = view.findViewById(R.id.textVocabu);
        txtType = view.findViewById(R.id.textType);
        txtVocul = view.findViewById(R.id.textView5);
        txtMean = view.findViewById(R.id.textMean);
        txtExp =  view.findViewById(R.id.textExplan);
        txtExam = view.findViewById(R.id.textExam);
        txtExam_trans = view.findViewById(R.id.textExamTrans);
        btnSearch = view.findViewById(R.id.imageButtonSearch);
        final Context ct = this.getContext();
        btnSpeak = view.findViewById(R.id.imageButtonSpeak);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edttInput.getText().toString();
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(ct);
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
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edttInput.getText().toString().trim() + ".mp3";
                playSound(input);
            }
        });
        return view;
    }


    private void playSound(String fileName) {
        MediaPlayer p = new MediaPlayer();
        try {
            Context ctx = this.getContext();
            AssetFileDescriptor afd = ctx.getAssets().openFd(fileName);
            p.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            p.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        p.start();
>>>>>>> 8baf95abc39d1a8c175eda18eb87c67bcb02b498
    }

}
