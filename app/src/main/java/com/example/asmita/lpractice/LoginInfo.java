package com.example.asmita.lpractice;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class LoginInfo extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      //setContentView(R.layout.activity_login_info);
      //setContentView(R.layout.content_display_message);
      setContentView(R.layout.content_select_chapter);

      //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      Intent intent = getIntent();
     //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
     /* String message = "Hello Done!";
      TextView textView = new TextView(this);
      textView.setTextSize(40);
      textView.setText(message);

      RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
      layout.addView(textView);*/
  }
}
