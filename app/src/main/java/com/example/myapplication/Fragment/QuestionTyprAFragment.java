package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class QuestionTyprAFragment extends Fragment {

    TextView txtQuestion;
    RadioGroup rdgAnswer;
    RadioButton rdChoiceA;
    RadioButton rdChoiceB;
    RadioButton rdChoiceC;
    RadioButton rdChoiceD;
    String curentAnswer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question1,container, false);
        txtQuestion =(TextView) view.findViewById(R.id.txtQuestion);
        rdgAnswer = (RadioGroup) view.findViewById(R.id.groupRadioAnswer);
        rdChoiceA =  (RadioButton)view.findViewById(R.id.radioButtonA);
        rdChoiceB = (RadioButton) view.findViewById(R.id.radioButtonB);
        rdChoiceC = (RadioButton) view.findViewById(R.id.radioButtonC);
        rdChoiceD = (RadioButton) view.findViewById(R.id.radioButtonD);

        rdgAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonA:
                        curentAnswer = rdChoiceA.getText().toString();
                        break;
                    case R.id.radioButtonB:
                        curentAnswer = rdChoiceB.getText().toString();
                        break;
                    case R.id.radioButtonC:
                        curentAnswer = rdChoiceC.getText().toString();
                        break;
                    case R.id.radioButtonD:
                        curentAnswer = rdChoiceD.getText().toString();
                        break;
                }
            }
        });

        return view;
    }

    public void  setQuestion(String answer, String a, String b, String c, String d){
        txtQuestion.setText(answer);
        rdChoiceA.setText(a);
        rdChoiceB.setText(b);
        rdChoiceC.setText(c);
        rdChoiceD.setText(d);
    }

    public String getAnswer(){
        return curentAnswer;
    }

}
