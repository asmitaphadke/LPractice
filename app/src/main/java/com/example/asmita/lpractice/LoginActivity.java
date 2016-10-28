package com.example.asmita.lpractice;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.asmita.lpractice.MESSAGE";
    private static final String TAG = LoginActivity.class.getSimpleName();
    private TextView loginerrortext;

    ///    http://52.76.158.251/school.letspractise.com/validateUser
    private EditText pwdEditText;
    private EditText emailEditText;
    private Button loginBtn;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (LPracticeApplication.getInstance().getUserSubscriptionDetails() != null){
            launchDashboard();
            return;
        }
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        emailEditText = (EditText) findViewById(R.id.login_email);
        pwdEditText = (EditText) findViewById(R.id.login_password);
        loginerrortext = (TextView) findViewById(R.id.login_error);
        loginBtn = (Button) findViewById(R.id.button_login);

        initProgressDialog();

        /////////test code///////////
        String defaultEmail = "nandariyer@gmail.com"; //"komalahluwalia0@gmail.com";
        String defaultPassword = "123456"; //"komal";
        emailEditText.setText(defaultEmail);
        pwdEditText.setText(defaultPassword);
        /////////end test code///////////
    }

    private void launchDashboard() {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
        //destroy the activity
        LoginActivity.this.finish();
    }

    private void initProgressDialog() {
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Validating user....");
        progressDialog.setTitle("Login");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
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
    protected void onResume() {
        super.onResume();
        loginerrortext.setVisibility(View.INVISIBLE);
    }

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



        /*Button button = (Button)layout.findViewById(R.id.popup_menu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {*/
        //disable clicks on the login UI
        showProgress(true);

        String lntext="",pwdtext="";

                if (emailEditText.getText() != null)
                {
                    lntext = emailEditText.getText().toString();

                    if(pwdEditText.getText() != null)
                    {
                        pwdtext = pwdEditText.getText().toString();
                    }
                }
                else
                {
                    //show error
                }

        LoginCommandProcessor loginCommandProcessor = new LoginCommandProcessor(lntext, pwdtext);
                //new LoginData("komalahluwalia06@gmail.com", "komal");
                //new LoginData("komalahluwalia0@gmail.com", "komal");

        LoginActionStatusListener listener = new LoginActionStatusListener();
        loginCommandProcessor.doLogin(listener);

        /*Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);*/
    }

    private class LoginActionStatusListener implements ActionStatusListener {
        @Override
        public void onSuccess() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //if activity is destroyed, don't update UI
                    if (LoginActivity.this.isDestroyed() ||
                            LoginActivity.this.isFinishing()) {
                        return;
                    }
                    loginerrortext.setVisibility(View.VISIBLE);
                    loginerrortext.setText("Successful Login");
                    showProgress(false);
                    launchDashboard();
                }
            });
        }

        @Override
        public void onFailure(String message) {
            Log.e(TAG, "communication failed " + message);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //if activity is destroyed, don't update UI
                    if (LoginActivity.this.isDestroyed() ||
                            LoginActivity.this.isFinishing()) {
                        return;
                    }
                    loginerrortext.setVisibility(View.VISIBLE);
                    loginerrortext.setText("Login Failed");
                    showProgress(false);
                }
            });
        }
    }

    private void showProgress(final boolean showing) {
        emailEditText.setEnabled(!showing);
        pwdEditText.setEnabled(!showing);
        loginBtn.setEnabled(!showing);

        if (showing) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }
}
