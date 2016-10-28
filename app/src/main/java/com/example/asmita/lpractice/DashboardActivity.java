package com.example.asmita.lpractice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private static final String TAG = DashboardActivity.class.getSimpleName();
    private static final String SPACE = " ";
    private static final String OPEN_BRACE = "(";
    private static final String CLOSE_BRACE = ")";
    private static final String SLASH = "/";
    List<SchoolTestData> titlelist;
    GridView grid;
    private UserSubscriptionDetails mUserSubscriptionDetails;

    private int childNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //updateTopicsList();


        mUserSubscriptionDetails = LPracticeApplication.getInstance().getUserSubscriptionDetails();
        mUserSubscriptionDetails.setDataRefreshListener(new DataRefreshListener() {
            @Override
            public void onNewDataAvailable(TYPE type) {
                updateDataOnUI(type);
            }
        });

        updateDataOnUI(DataRefreshListener.TYPE.BOARD_INFO);
        updateDataOnUI(DataRefreshListener.TYPE.MCQ_INFO);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserSubscriptionDetails.setDataRefreshListener(null);
    }

    private void updateTopicsList() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /************** Inserting Rating data in Grid **********/
                titlelist = new ArrayList<SchoolTestData>();
                grid = (GridView) findViewById(R.id.grid_pendingSchoolTests);
                PendingTestTopicList pendingTestTopicList =
                        mUserSubscriptionDetails.getPendingSchoolTestsForChild(childNumber);
                if (pendingTestTopicList == null || pendingTestTopicList.getCount() <= 0) {
                    //there is not info available
                    return;
                }

                List<PendingTestTopic> topics=new ArrayList<PendingTestTopic>();
                for (int counter = 0; counter < pendingTestTopicList.getCount(); counter++) {
                    topics.add(pendingTestTopicList.getTest(counter));
                }
                SchoolTestArrayAdapter adp = new SchoolTestArrayAdapter(DashboardActivity.this,
                        R.layout.school_test_data, topics);
                grid.setAdapter(adp);

                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /**
                     * @param parent The AdapterView where the click happened.
                     * @param view The view within the AdapterView that was clicked (this
                     *            will be a view provided by the adapter)
                     * @param position The position of the view in the adapter.
                     * @param id The row id of the item that was clicked.                     */
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {
                        PendingTestTopic testTopic =
                                (PendingTestTopic) parent.getAdapter().getItem(position);
                        Log.d(TAG, "Topic = " + testTopic.getTitle());
                        Intent intent = new Intent(getApplicationContext(), MCQActivity.class);
                        intent.putExtra("ChildNumber", childNumber);
                        intent.putExtra("TopicId", testTopic.getId());
                        //startActivity(intent);
                    }
                });
            }
        });
    }

    private void updateDataOnUI(final DataRefreshListener.TYPE type) {
        switch (type) {
            case BOARD_INFO:
            case CLASS_INFO:
                updateTitle();
                break;

            case MCQ_INFO:
                updateTopicsList();
        }
    }

    private void updateTitle() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Populating ChildName TextView with data received by database
                TextView tvChildNameBoardStd = (TextView) findViewById(R.id.child_name_board_std);
                String childNameBoardStd =
                        mUserSubscriptionDetails.getNameForChild(childNumber) +
                                SPACE + OPEN_BRACE +
                                mUserSubscriptionDetails.getBoardNameForChild(childNumber) +
                                SLASH +
                                mUserSubscriptionDetails.getClassNameForChild(childNumber) +
                                CLOSE_BRACE;
                tvChildNameBoardStd.setText(childNameBoardStd);
            }
        });
    }

    private void logUserSubscriptionDetails() {
        if (mUserSubscriptionDetails == null) {
            Log.i(TAG, "userSubscriptionDetails not available");

            return;
        }

        Log.i(TAG, mUserSubscriptionDetails.toString());
        int childCount = mUserSubscriptionDetails.childCount();
        for (int i = 0; i < childCount; i++) {
            String boardName = mUserSubscriptionDetails.getBoardNameForChild(i);
            String className = mUserSubscriptionDetails.getClassNameForChild(i);
            Log.i(TAG, "Child = " + (i + 1) + " Board = " + boardName);
            Log.i(TAG, "Child = " + (i + 1) + " Class = " + className);

            Log.i(TAG, "Child = " + (i + 1) + " TestTopics = ");
            String[] testTopics = mUserSubscriptionDetails.getPendingSchoolTestTopicNamesForChild(i);
            for (String topicName : testTopics) {
                Log.i(TAG, topicName + " ## ");
            }
        }
    }

    /*****@Override
     public boolean onCreateOptionsMenu(Menu menu) {
     getMenuInflater().inflate(R.menu.activity_main, menu);
     return true;
     }*********/


    /**
     * Called when the user clicks the SchoolTestRatings button
     */
    public void showSchoolTestResults(View view) {

        Intent intent = new Intent(this, ShowRating.class);
        startActivity(intent);

    }

    /**
     * Called when the user clicks the FreeRapidAssessment button
     */
    public void beginFreeTest(View view) {

        Intent intent = new Intent(this, ShowRating.class);
        startActivity(intent);

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DashboardActivity Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.asmita.lpractice/http/host/path")
        );
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DashboardActivity Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.asmita.lpractice/http/host/path")
        );
    }
}
