package com.example.asmita.lpractice;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asmita on 12-10-2016.
 * Object of ChildInfo class holds the Information about a Child,
 * received from the Server, after successful Login.
 */

public class ChildInfo {
    private static final String TAG = ChildInfo.class.getSimpleName();
    @SerializedName("user_id")
    private Integer mUserId;
    @SerializedName("child_profile_id")
    private Integer mChildProfileID;
    @SerializedName("child_profile_name")
    private String mChildProfileName;
    @SerializedName("child_board_id")
    private Integer mChildBoardID;
    @SerializedName("child_class_id")
    private Integer mChildClassID;
    @SerializedName("child_school_id")
    private Integer mChildSchoolID;
    @SerializedName("profile_changed_once")
    private Boolean mProfileChangedOnce;
    @SerializedName("board")
    private String mBoard;
    @SerializedName("childClass")
    private String mChildClass;
    @SerializedName("childSchool")
    private String mChildSchool;
    @SerializedName("referencedSchoolId")
    private Integer mReferenceSchoolId;
    @SerializedName("paymentPlan")
    private String mPaymentPlan;
    @SerializedName("currentProfile")
    private Boolean mCurrentProfile;

    private BoardDetails mBoardDetails;
    private ClassDetail mClassDetails;
    private PendingTestTopicList mPendingSchoolTests;

    private ChildInfo() {
    }

    /* Stores the result from server, received in JSON format in Class Object */
/*
    public static ChildInfo fromJson(String result) {
        //parse the Json and update the object
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(result, ChildInfo.class);
    }
*/

    /* Get Board Name for a Child, from server, given Board ID */
    public void refreshBoardName(final ActionStatusListener listener) {
        BoardDetails.loadFromServer(mChildBoardID, new CommunicationResultListener() {
            @Override
            public void onSuccess(String result) {
                mBoardDetails = BoardDetails.fromJson(result);
                listener.onSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
                listener.onFailure(e.getMessage());
            }
        });
    }

    /* Get Board Name for a Child */
    public String getBoardName() {
        return (mBoardDetails == null || mBoardDetails.getBoardName() == null) ?
                "" : mBoardDetails.getBoardName();
    }

    /* Get Class Name for a Child, from server, given Class ID */
    public void refreshClassName(final ActionStatusListener listener) {
        ClassDetail.loadFromServer(mChildClassID, new CommunicationResultListener() {
            @Override
            public void onSuccess(String result) {
                mClassDetails = ClassDetail.fromJson(result);
                listener.onSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
                listener.onFailure(e.getMessage());
            }
        });
    }

    /* Get Class Name for a Child */
    public String getClassName() {
        return (mClassDetails == null || mClassDetails.getClassName() == null) ?
                "" : mClassDetails.getClassName();
    }

    /* Get List of Pending School Tests for a Child, from server, given Child Profile ID */
    public void refreshPendingSchoolTests(final ActionStatusListener listener) {
        PendingTestTopicList.loadFromServer(mChildProfileID, new CommunicationResultListener() {
            @Override
            public void onSuccess(String result) {
                mPendingSchoolTests = PendingTestTopicList.fromJson(result);
                listener.onSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
                listener.onFailure(e.getMessage());
            }
        });
    }
    public String[] getPendingSchoolTestTopics() {
        return (mPendingSchoolTests == null || mPendingSchoolTests.getPendingSchoolTestTopics() == null) ?
                new String[0] : mPendingSchoolTests.getPendingSchoolTestTopics();
    }

   /*********************
    public String[] getMCQs() {
        return (mMCQs == null || mMCQs.getPendingSchoolTestTopics() == null) ?
                new String[0] : mMCQs.getPendingSchoolTestTopics();
    }
*************/
    /* Convert ChildInfo object to String format */
    @Override
    public String toString() {
        return "ChildInfo{" +
                "mUserId=" + mUserId +
                ", mChildProfileID=" + mChildProfileID +
                ", mChildProfileName='" + mChildProfileName + '\'' +
                ", mChildBoardID=" + mChildBoardID +
                ", mChildClassID=" + mChildClassID +
                ", mChildSchoolID=" + mChildSchoolID +
                ", mProfileChangedOnce=" + mProfileChangedOnce +
                ", mBoard='" + mBoard + '\'' +
                ", mChildClass='" + mChildClass + '\'' +
                ", mChildSchool='" + mChildSchool + '\'' +
                ", mReferenceSchoolId=" + mReferenceSchoolId +
                ", mPaymentPlan='" + mPaymentPlan + '\'' +
                ", mCurrentProfile=" + mCurrentProfile +
                '}';
    }

    public String getName() {
        return mChildProfileName;
    }

    public PendingTestTopicList getPendingSchoolTests() {
        return mPendingSchoolTests;
    }
}
