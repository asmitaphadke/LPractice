package com.example.asmita.lpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ShowRating extends AppCompatActivity {

    List<String> ratinglist;
    GridView ratinggrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rating);


                // ************   Trying to populate Spinner with Subjects

                 Spinner spinner = (Spinner) findViewById(R.id.sub_names_db);
                 // Create an ArrayAdapter using the string array and a default spinner layout
                 ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                 R.array.subjects, android.R.layout.simple_spinner_item);
                 // Specify the layout to use when the list of choices appears
                 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 // Apply the adapter to the spinner
                 spinner.setAdapter(adapter);


                 // Inserting Rating data in Grid
                 ratinglist=new ArrayList<String>();
                 //grid=(GridView) findViewById(R.id.gridView1);
                 ratinggrid = (GridView) findViewById(R.id.grid_schoolTestRating);

                ratinglist.add("Nouns");
                ratinglist.add("Well Done...");
                ratinglist.add("Adjectives");
                ratinglist.add("Well Done...");
                ratinglist.add("Adjectives");
                ratinglist.add("Excellent!");

                 ArrayAdapter<String> adp=new ArrayAdapter<String> (this,
                 android.R.layout.simple_dropdown_item_1line,ratinglist);
                 ratinggrid.setAdapter(adp);

                /****    grid.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(), list.get(arg2),
                Toast.LENGTH_SHORT).show();
                }
                });
                 }
                 @Override
                 public boolean onCreateOptionsMenu(Menu menu) {
                 getMenuInflater().inflate(R.menu.activity_main, menu);
                 return true;
                 }*********/

    }

    /** Called when the user clicks the BackToHome button */
    public void srBackToHome(View view) {

        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);

    }

}




