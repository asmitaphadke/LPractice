package com.example.asmita.lpractice;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asmita on 26-09-2016.
 */
public class SchoolTestArrayAdapter extends ArrayAdapter<PendingTestTopic>{

    private final Context mActivityContext;

    public SchoolTestArrayAdapter(Context context,
                                  int layoutResourceId,
                                  List<PendingTestTopic> pendingTestTopicList) {
        super(context, layoutResourceId, pendingTestTopicList);
        mActivityContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null) {
            LayoutInflater inflater = ((Activity) mActivityContext).getLayoutInflater();
            row = inflater.inflate(R.layout.school_test_data, parent, false);
        }

        TextView testtitle = (TextView)row.findViewById(R.id.test_title);
        testtitle.setText(super.getItem(position).getTitle());

        return row;
    }
}

