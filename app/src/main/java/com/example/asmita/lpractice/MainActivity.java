package com.example.asmita.lpractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.asmita.lpractice.MESSAGE";
    String mUserName;
    String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_main, menu);
        // Lp Menu code
        //getMenuInflater().inflate(R.menu.lp_menu, menu);
        return true;

    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the Login button */
    public void sendMessage(View view) {
        //new LoginOperation(mUserName, mPassword).doLogin();
       /* Intent intent = new Intent(this, LoginInfo.class);
        EditText emailText = (EditText) findViewById(R.id.login_email);
        String email = emailText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, email);
        startActivity(intent);*/

        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);

    }
}
