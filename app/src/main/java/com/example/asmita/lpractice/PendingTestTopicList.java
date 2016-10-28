package com.example.asmita.lpractice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Asmita on 20-10-2016.
 * Object of PendingTestTopicList class holds the List of PendingSchoolTests,
 * for the selected Child, received from the Server.
 */
public class PendingTestTopicList {

    final private PendingTestTopic[] mPendingSchoolTestList;

    private PendingTestTopicList(final PendingTestTopic[] pendingTestTopics) {
        mPendingSchoolTestList = pendingTestTopics;
    }

    public static PendingTestTopicList fromJson (final String serializedClassDetail) {
        //parse the Json and update the object
        Gson gson = new GsonBuilder().create();

        PendingTestTopic[] pendingTestTopics =
            gson.fromJson(serializedClassDetail, PendingTestTopic[].class);

        return new PendingTestTopicList(pendingTestTopics);
    }


    public static void loadFromServer(Integer childProfileId, CommunicationResultListener listener) {
        PostDataToServer serverCommunication =
                new PostDataToServer(
                        ServerCommunicationInfo.protocol,
                        ServerCommunicationInfo.baseUrl,
                        ServerCommunicationInfo.pendingSchoolTestList,
                        PostDataToServer.RequestMethod.GET,
                        listener);
        serverCommunication.execute(childProfileId.toString());
    }

    public String[] getPendingSchoolTestTopics() {
        String[] list = new String[mPendingSchoolTestList.length];

        for (int itemNum = 0; itemNum < mPendingSchoolTestList.length; itemNum++) {
            list[itemNum] = mPendingSchoolTestList[itemNum].getPendingSchoolTestTopic();
        }
        return list;
    }

    public PendingTestTopic getTest(int itemNum) {
        return mPendingSchoolTestList[itemNum];
    }

    public int getCount() {
        return mPendingSchoolTestList.length;
    }
}
