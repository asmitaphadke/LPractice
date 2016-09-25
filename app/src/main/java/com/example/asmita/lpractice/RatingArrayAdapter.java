package com.example.asmita.lpractice;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asmita on 25-09-2016.
 */
public class RatingArrayAdapter extends ArrayAdapter<RatingData>{

    private final int mLayoutResourceId;
    private final List<RatingData> ratingDataList;
    private final Context mActivityContext;

    public RatingArrayAdapter(Context context, int layoutResourceId, List<RatingData> ratinglist) {
        super(context, layoutResourceId, ratinglist);
        mLayoutResourceId = layoutResourceId;
        ratingDataList = ratinglist;
        mActivityContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null) {
            LayoutInflater inflater = ((Activity) mActivityContext).getLayoutInflater();
            row = inflater.inflate(R.layout.rating_table_row, parent, false);
        }

        TextView chaptername = (TextView)row.findViewById(R.id.chapter_name);
        TextView rating = (TextView)row.findViewById(R.id.rating);


        RatingData ratingpos = ratingDataList.get(position);
        chaptername.setText(ratingpos.getChapterName());
        rating.setText(ratingpos.getRating());

        return row;
    }
}

