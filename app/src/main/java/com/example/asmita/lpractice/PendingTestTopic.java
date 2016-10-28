package com.example.asmita.lpractice;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asmita on 18-10-2016.
 * Object of PendingTestTopic class holds the Information about
 * a Pending School Test, for the selected Child, received from the Server.
 */

/* JSON received
{
        "salt": "4418758619751461216093120",
        "user_id": 35,
        "child_profile_id": 44,
        "topic_id": 582,
        "link_generate_date": 1461283200000,
        "link_consumed_date": null,
        "is_taken": false,
        "topicName": "Learning About Directions"
        }
*/

public class PendingTestTopic {
    private static final String TAG = PendingTestTopic.class.getSimpleName();
    @SerializedName("user_id")
    private int mUserId;
    @SerializedName("child_profile_id")
    private String mChildProfileID;
    @SerializedName("topic_id")
    private String mTopicId;
    @SerializedName("topicName")
    private String mTopicName;

    @SerializedName("salt")
    private String mSalt;

    @SerializedName("link_generate_date")
    private String mLinkGenerateDate;

    @SerializedName("link_consumed_date")
    private String mLinkConsumedDate;

    @SerializedName("is_taken")
    private Boolean mIsTaken;

    private MCQList mMCQs;

    private PendingTestTopic() {}

    /*public static PendingTestTopic fromJson (final String serializedClassDetail) {
        //parse the Json and update the object
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(serializedClassDetail, PendingTestTopic.class);
    }*/

    @Override
    public String toString() {
        return "PendingSchoolTests{" +
                "mUserId=" + mUserId +
                ", mChildProfileID='" + mChildProfileID + '\'' +
                ", mTopicId='" + mTopicId + '\'' +
                ", mTopicName='" + mTopicName + '\'' +
                ", mSalt='" + mSalt + '\'' +
                ", mLinkGenerateDate='" + mLinkGenerateDate + '\'' +
                ", mLinkConsumedDate='" + mLinkConsumedDate + '\'' +
                ", mIsTaken=" + mIsTaken +
                '}';
    }

    /* Get List of MCQs for the selected Test, from server, given Test ID(salt) */
    public void refreshMCQs(final ActionStatusListener listener) {
        MCQList.loadFromServer(mSalt, new CommunicationResultListener() {
            @Override
            public void onSuccess(String result) {
                mMCQs = MCQList.fromJson(result);
                listener.onSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
                listener.onFailure(e.getMessage());
            }
        });
    }

    public String getPendingSchoolTestTopic() {
        return mTopicName;
    }

    public String getTitle() {
        return mTopicName;
    }

    public String getId() {
        return mTopicId;
    }
}
