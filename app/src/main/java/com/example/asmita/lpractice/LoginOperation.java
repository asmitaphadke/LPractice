package com.example.asmita.lpractice;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Asmita on 21-06-2016.
 */
public class LoginOperation extends AppCompatActivity{
    private final String mUserName;
    private final String mPassword;

    LoginOperation(final String userName,
                   final String password) {
        mUserName = userName;
        mPassword = password;
    }


    public void doLogin() {
        //do networkcalls
    }


}
