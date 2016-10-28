package com.example.asmita.lpractice;

import android.app.Application;

/**
 * Created by Asmita on 19-10-2016.
 */
public class LPracticeApplication extends Application {
    private UserSubscriptionDetails mUserSubscriptionDetails;
    private static LPracticeApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public UserSubscriptionDetails getUserSubscriptionDetails() {
        return mUserSubscriptionDetails;
    }

    public void setUserSubscriptionDetails(UserSubscriptionDetails mUserSubscriptionDetails) {
        this.mUserSubscriptionDetails = mUserSubscriptionDetails;
    }

    public static LPracticeApplication getInstance() {
        return mInstance;
    }
}
