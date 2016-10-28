package com.example.asmita.lpractice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectChapter extends AppCompatActivity implements View.OnClickListener {
    int selectedSubjectNo=0;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ************   Trying to populate Spinner with Subjects
        spinner = (Spinner) findViewById(R.id.sub_names);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subjects, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedSubjectNo = (int) spinner.getSelectedItemId();
            }
        });

        /*********** Initializing RadioGroup with options ***********/
        LinearLayout layout = (LinearLayout) findViewById(R.id.chapter_layout);
        RadioGroup radioGroup = new RadioGroup(this);

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout.addView(radioGroup, p);
        addRadioButtons(radioGroup, p);

    }

    private void addRadioButtons(final RadioGroup radioGroup, final LinearLayout.LayoutParams layout) {
        String[] chapters = {"Nouns", "Verbs", "Adjectives", "Pronouns"};

        for (String chapter: chapters) {
            RadioButton radioButtonView = new RadioButton(this);
            radioButtonView.setText(chapter);
            //radioButtonView.setOnClickListener(this);
            radioGroup.addView(radioButtonView, layout);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Lp Menu code
        getMenuInflater().inflate(R.menu.lp_menu, menu);
        return true;

    }

    public void onClick(View view) {
        try {
            String s = ((RadioButton) view).getText().toString();
            Toast.makeText(SelectChapter.this, "This is: " + s,
                    Toast.LENGTH_LONG).show();
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private View.OnClickListener mThisButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            String s = ((RadioButton) v).getText().toString();
            Toast.makeText(SelectChapter.this, "Hello from 2!" + s,
                    Toast.LENGTH_LONG).show();
        }
    };

    /** Called when the user clicks the BeginTest button */
    public void beginTest(View view) {

        Intent intent = new Intent(this, MCQActivity.class);
        startActivity(intent);

    }

}
