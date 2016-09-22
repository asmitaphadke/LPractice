package com.example.asmita.lpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MCQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout mcqlayout = (LinearLayout) findViewById(R.id.mcq_options);

        RadioGroup mcqradioGroup = new RadioGroup(this);
        LinearLayout.LayoutParams mcqp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        mcqlayout.addView(mcqradioGroup, mcqp);

        addMCQRadioButtons(mcqradioGroup, mcqp);
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
