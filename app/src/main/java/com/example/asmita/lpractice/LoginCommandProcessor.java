package com.example.asmita.lpractice;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asmita on 12-10-2016.
 */
public class LoginCommandProcessor {
    private static final String TAG = LoginCommandProcessor.class.getSimpleName();

    @SerializedName("email")
    private final String mLoginEmail;
    @SerializedName("password")
    private final String mPassword;

    public LoginCommandProcessor(String lntext, String pwdtext) {
        mLoginEmail = lntext;
        mPassword = pwdtext;
    }


    private String toJson() {
        //convert the object contents to Json
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public void doLogin(final ActionStatusListener uiListener) {
        PostDataToServer serverCommunication =
                new PostDataToServer(
                        ServerCommunicationInfo.protocol,
                        ServerCommunicationInfo.baseUrl,
                        ServerCommunicationInfo.loginRequestMethod,
                        new CommunicationResultListener() {
                            @Override
                            public void onSuccess(String result) {
                                UserSubscriptionDetails userSubscriptionDetails =
                                        UserSubscriptionDetails.fromJson(result);

                                LPracticeApplication.getInstance().
                                        setUserSubscriptionDetails(userSubscriptionDetails);
                                Log.i(TAG, userSubscriptionDetails.toString());

                                int childCount = userSubscriptionDetails.childCount();
                                for (int i = 0; i < childCount; i++) {
                                    userSubscriptionDetails.refreshBoardNameForChild(i);
                                    userSubscriptionDetails.refreshClassNameForChild(i);
                                    userSubscriptionDetails.refreshPendingSchoolTestForChild(i);

                                    String boardName = userSubscriptionDetails.getBoardNameForChild(i);
                                    String className = userSubscriptionDetails.getClassNameForChild(i);
                                    //String testTopic = userSubscriptionDetails.getPendingSchoolTestTopicNamesForChild(i);

                                    Log.i(TAG, "Child = " + (i + 1) + " Board = " + boardName);
                                    Log.i(TAG, "Child = " + (i + 1) + " Class = " + className);
                                    //Log.i(TAG, "Child = " + (i + 1) + " TestTopic = " + testTopic);
                                }

                                uiListener.onSuccess();
                            }

                            @Override
                            public void onFailure(Exception e) {
                                Log.e(TAG, "communication failed " + e.toString());
                                uiListener.onFailure(e.getMessage());
                            }
                        });

        String inputJson = toJson();
        serverCommunication.execute(inputJson);
    }
}
