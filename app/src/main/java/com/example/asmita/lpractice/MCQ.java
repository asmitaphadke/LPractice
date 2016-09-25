package com.example.asmita.lpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MCQ extends AppCompatActivity {

    TextView mcqQuestion;
    TextView showingQuestionText;
    List<String> mcqQuestionList;
    ImageView previousQuestion;
    ImageView nextQuestion;
    int showingQuestion = 0;
    int totalQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set MCQquestions
        mcqQuestionList =new ArrayList<String>();

        mcqQuestionList.add("Revision : The Noun 'birds' is a ");
        mcqQuestionList.add("The Noun 'India' is a ");
        mcqQuestionList.add("Type of Noun 'book' is ");
        mcqQuestionList.add("The Noun 'Riya' is a ");
        mcqQuestionList.add("Type of Noun 'village' is ");
        totalQuestions = mcqQuestionList.size();

        mcqQuestion = (TextView) findViewById(R.id.mcq_question);
        previousQuestion = (ImageView)findViewById(R.id.previmg) ;
        nextQuestion = (ImageView)findViewById(R.id.nextimg) ;
        showingQuestionText = (TextView) findViewById(R.id.question_number);

        LinearLayout mcqlayout = (LinearLayout) findViewById(R.id.mcq_options);

        previousQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showingQuestion--;
                if (showingQuestion < 0) {
                    showingQuestion = 0;
                }
                setMcqQuestion();
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showingQuestion++;
                if (showingQuestion >= totalQuestions) {
                    showingQuestion = totalQuestions-1;
                }
                setMcqQuestion();
            }
        });
        // Set MCQoptions
        RadioGroup mcqradioGroup = new RadioGroup(this);
        LinearLayout.LayoutParams mcqp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        mcqlayout.addView(mcqradioGroup, mcqp);

        setMcqQuestion();
        addMCQRadioButtons(mcqradioGroup, mcqp);
    }

    private void setMcqQuestion() {
        showingQuestionText.setText("Question No. " + (showingQuestion+1) + " of " + totalQuestions);
        mcqQuestion.setText(mcqQuestionList.get(showingQuestion));
    }
    private void addMCQRadioButtons(final RadioGroup radioGroup, final LinearLayout.LayoutParams layout) {
        String[] options = {"Proper Noun", "Common Noun", "Singular Noun", "None of these"};

        for (String option: options) {
            RadioButton radioButtonView = new RadioButton(this);
            radioButtonView.setText(option);
            //radioButtonView.setOnClickListener(this);
            radioGroup.addView(radioButtonView, layout);
        }
    }

    /** Called when the user clicks the SubmitTest button */
    public void submitTest(View view) {

        Intent intent = new Intent(this, Result.class);
        startActivity(intent);

    }
}
