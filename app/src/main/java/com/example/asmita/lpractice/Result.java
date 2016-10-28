package com.example.asmita.lpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {

    List<ResultsData> qslist;
    GridView qsgrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inserting Rating data in Grid
        qslist=new ArrayList<ResultsData>();
        qsgrid = (GridView) findViewById(R.id.grid_qs);


        qslist.add(new ResultsData(
                "Question: The noun 'birds' is a",
                "Correct Answer:  common noun",
                "Chosen Answer:  common noun "));
        qslist.add(new ResultsData(
                "Question : The Noun 'India' is a",
                "Correct Answer:  proper noun",
                "Chosen Answer:  common noun"));
        qslist.add(new ResultsData(
                "Question : Type of Noun 'book' is",
                "Correct Answer:  common noun",
                "Chosen Answer:  common noun"));
        qslist.add(new ResultsData(
                "Question : The Noun 'Riya' is a",
                "Correct Answer:  proper noun",
                "Chosen Answer:  proper noun "));
        qslist.add(new ResultsData(
                "Question : Type of Noun 'village' is",
                "Correct Answer:  common noun",
                "Chosen Answer:  proper noun"));

        ResultsArrayAdapter adp=new ResultsArrayAdapter (this,
                R.layout.result_questions, qslist);
        qsgrid.setAdapter(adp);
    }
    /** Called when the user clicks the SubmitTest button */
    public void backToHome(View view) {

        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);

    }
}
