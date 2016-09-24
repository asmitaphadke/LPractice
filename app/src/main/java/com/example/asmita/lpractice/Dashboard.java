package com.example.asmita.lpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    List<String> list;
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inserting Rating data in Grid
        list=new ArrayList<String>();
        grid = (GridView) findViewById(R.id.grid_pendingSchoolTests);

        list.add("English : Nouns");
        list.add("Maths : Fractions");
        list.add("English : Adjectives");
        list.add("Maths : Number Division");

        ArrayAdapter<String> adp=new ArrayAdapter<String> (this,
                android.R.layout.simple_dropdown_item_1line,list);
        grid.setAdapter(adp);

            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub

                //Toast.makeText(getBaseContext(), list.get(arg2),
                  //      Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MCQ.class);
                startActivity(intent);

            }
        });
    }
    /*****@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*********/


    /** Called when the user clicks the BeginTest button */
    public void showSchoolTestResults(View view) {

        Intent intent = new Intent(this, ShowRating.class);
        startActivity(intent);

    }
    /** Called when the user clicks the BeginTest button */
    public void beginFreeTest(View view) {

        Intent intent = new Intent(this, ShowRating.class);
        startActivity(intent);

    }
}
