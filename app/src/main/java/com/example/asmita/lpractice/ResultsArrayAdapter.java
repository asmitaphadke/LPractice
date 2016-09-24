package com.example.asmita.lpractice;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asmita on 23-09-2016.
 */
public class ResultsArrayAdapter extends ArrayAdapter<ResultsData> {
    private final int mLayoutResourceId;
    private final List<ResultsData> resultsDataList;
    private final Context mActivityContext;

    public ResultsArrayAdapter(Context context, int layoutResourceId, List<ResultsData> qslist) {
        super(context, layoutResourceId, qslist);
        mLayoutResourceId = layoutResourceId;
        resultsDataList = qslist;
        mActivityContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null) {
            LayoutInflater inflater = ((Activity) mActivityContext).getLayoutInflater();
            row = inflater.inflate(R.layout.result_questions, parent, false);
        }

        TextView question = (TextView)row.findViewById(R.id.qs);
        TextView expectedAnswer = (TextView)row.findViewById(R.id.exp_ans);
        TextView actualAnswer = (TextView)row.findViewById(R.id.act_ans);

        ResultsData result = resultsDataList.get(position);
        question.setText(result.getQuestion());
        expectedAnswer.setText(result.getExpectedAnswer());
        actualAnswer.setText(result.getActualAnswer());

        return row;
    }
}
