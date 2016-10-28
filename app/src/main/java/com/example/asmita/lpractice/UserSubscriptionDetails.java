package com.example.asmita.lpractice;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import static com.example.asmita.lpractice.DataRefreshListener.TYPE.*;

/**
 * Created by Asmita on 26-09-2016.
 * Object of UserSubscriptionDetails class holds the Information about an User,
 * received from the Server, after successful Login.
 */

public class UserSubscriptionDetails {

    private static final String TAG = UserSubscriptionDetails.class.getSimpleName();
    @SerializedName("user_id")
    private Integer mUserID;
    @SerializedName("user_email")
    private String mLoginEmail;
    @SerializedName("user_password")
    private String mPassword;
    @SerializedName("user_name")
    private String mUsername;

    @SerializedName("user_locked_out")
    private Boolean mUserLockedOut;

    @SerializedName("password_last_changed_dttm")
    private long mPasswordLastChangedDttm;

    @SerializedName("user_reg_done")
    private Boolean mUserRegDone;

    @SerializedName("user_reg_link_sent_dttm")
    private long mUserRegLinkSentDttm;

    @SerializedName("user_reset_password_link")
    private String mUserResetPasswordLink;

    @SerializedName("user_reset_password_link_sent_dttm")
    private long mUserResetPasswordLinkSentDttm;

    @SerializedName("user_state")
    private int mUserState;

    @SerializedName("user_city")
    private int mUserCity;

    @SerializedName("user_country")
    private int mUserCountry;

    @SerializedName("user_zipcode")
    private long mUserZipcode;

    @SerializedName("user_last_logged_in_dttm")
    private long mUserLastLoggedInDttm;

    @SerializedName("user_created_dttm")
    private long mUserCreatedDttm;

    @SerializedName("user_currently_logged_in")
    private Boolean mUserCurrentlyLoggedIn;

    @SerializedName("user_address")
    private String mUserAddress;

    @SerializedName("user_phone")
    private long mUserPhone;

    @SerializedName("user_reg_link_salt")
    private String mUserRegLinkSalt;

    @SerializedName("user_source")
    private String mUserSource;

    @SerializedName("city")
    private String mCity;

    @SerializedName("state")
    private String mState;

    @SerializedName("country")
    private String mCountry;

    @SerializedName("children")
    private ChildInfo[] mChildren;

    @SerializedName("userDetails")
    private String mUserDetails;
    @SerializedName("userProfileComplete")
    private Boolean mUserProfileComplete;
    @SerializedName("activeProfile")
    private String mActiveProfile;

    private DataRefreshListener mDataRefreshListener = getMockDataRefreshListener();


    private UserSubscriptionDetails() {}

    /* Stores the result from server, received in JSON format in Class Object */
    public static UserSubscriptionDetails fromJson(String result) {
        //parse the Json and update the object
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(result, UserSubscriptionDetails.class);
    }

    public String getUserName() {
        return (mUsername==null)? "User Name not Set" : mUsername;
    }

    @Override
    public String toString() {
        return "UserSubscriptionDetails{" +
                "mUserID=" + mUserID +
                ", mLoginEmail='" + mLoginEmail + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mUsername='" + mUsername + '\'' +
                ", mUserLockedOut=" + mUserLockedOut +
                ", mPasswordLastChangedDttm=" + mPasswordLastChangedDttm +
                ", mUserRegDone=" + mUserRegDone +
                ", mUserRegLinkSentDttm=" + mUserRegLinkSentDttm +
                ", mUserResetPasswordLink='" + mUserResetPasswordLink + '\'' +
                ", mUserResetPasswordLinkSentDttm=" + mUserResetPasswordLinkSentDttm +
                ", mUserState=" + mUserState +
                ", mUserCity=" + mUserCity +
                ", mUserCountry=" + mUserCountry +
                ", mUserZipcode=" + mUserZipcode +
                ", mUserLastLoggedInDttm=" + mUserLastLoggedInDttm +
                ", mUserCreatedDttm=" + mUserCreatedDttm +
                ", mUserCurrentlyLoggedIn=" + mUserCurrentlyLoggedIn +
                ", mUserAddress='" + mUserAddress + '\'' +
                ", mUserPhone=" + mUserPhone +
                ", mUserRegLinkSalt='" + mUserRegLinkSalt + '\'' +
                ", mUserSource='" + mUserSource + '\'' +
                ", mCity='" + mCity + '\'' +
                ", mState='" + mState + '\'' +
                ", mCountry='" + mCountry + '\'' +
                ", children=" + Arrays.toString(mChildren) +
                ", mUserDetails='" + mUserDetails + '\'' +
                ", mUserProfileComplete=" + mUserProfileComplete +
                ", mActiveProfile='" + mActiveProfile + '\'' +
                '}';
    }

    public int childCount() {
        return mChildren.length;
    }

    public void refreshBoardNameForChild(final int i) {
        mChildren[i].refreshBoardName(new ActionStatusListener() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "Child = " + (i+1) + " Board = " + mChildren[i].getBoardName());
                mDataRefreshListener.onNewDataAvailable(BOARD_INFO);
            }

            @Override
            public void onFailure(String message) {
                Log.i(TAG, "Board name refresh failed with message " + message);
            }
        });
    }

    public void refreshClassNameForChild(final int i) {
        mChildren[i].refreshClassName(new ActionStatusListener() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "Child = " + (i+1) + " Class = " + mChildren[i].getClassName());
                mDataRefreshListener.onNewDataAvailable(CLASS_INFO);
            }

            @Override
            public void onFailure(String message) {
                Log.i(TAG, "Class name refresh failed with message " + message);
            }
        });
    }

    public void refreshPendingSchoolTestForChild(final int i) {
        mChildren[i].refreshPendingSchoolTests(new ActionStatusListener() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "Child = " + (i+1) + " Class = " + mChildren[i].getPendingSchoolTestTopics());
                mDataRefreshListener.onNewDataAvailable(MCQ_INFO);
            }

            @Override
            public void onFailure(String message) {
                Log.i(TAG, "Pending School Tests refresh failed with message " + message);
            }
        });
    }

    public String getBoardNameForChild(int i) {
        String boardName = mChildren[i].getBoardName();
        Log.i(TAG, "Child = " + (i+1) + " Board = " + boardName);
        return boardName;
    }

    public String getClassNameForChild(int i) {
        String className = mChildren[i].getClassName();
        Log.i(TAG, "Child = " + (i+1) + " Class = " + className);
        return className;
    }

    public String[] getPendingSchoolTestTopicNamesForChild(int i) {
        String[] testTopic = mChildren[i].getPendingSchoolTestTopics();
        Log.i(TAG, "Child = " + (i+1) + " Pending School Test Topic = " + testTopic);
        return testTopic;
    }

    public PendingTestTopicList getPendingSchoolTestsForChild(int childNumber) {
        return mChildren[childNumber].getPendingSchoolTests();
    }

    public String getNameForChild(int childNumber) {
        return mChildren[childNumber].getName();
    }

    public void setDataRefreshListener(DataRefreshListener dataRefreshListener) {
        if (dataRefreshListener == null) {
            mDataRefreshListener = getMockDataRefreshListener();
        } else {
            mDataRefreshListener = dataRefreshListener;
        }
    }

    private DataRefreshListener getMockDataRefreshListener() {
        return new DataRefreshListener() {
            @Override
            public void onNewDataAvailable(TYPE type) {
                //do nothing on purpose
                Log.d(TAG, "getMockDataRefreshListener type = " + type);
            }
        };
    }
}
