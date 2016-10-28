package com.example.asmita.lpractice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Asmita on 21-10-2016.
 * Object of MCQList class holds the List of MCQs,
 * for the selected Test, received from the Server.
 */
public class MCQList {
    final private MCQ[] mMCQList;

    private MCQList(final MCQ[] MCQs) {
        mMCQList = MCQs;
    }

    public static MCQList fromJson (final String serializedClassDetail) {
        //parse the Json and update the object
        Gson gson = new GsonBuilder().create();

        MCQ[] MCQs =
                gson.fromJson(serializedClassDetail, MCQ[].class);

        return new MCQList(MCQs);
    }


    public static void loadFromServer(String saltTopicID, CommunicationResultListener listener) {
        //TEST code
        saltTopicID = "318-1114046411475738056402";
        //end test code

        PostDataToServer serverCommunication =
                new PostDataToServer(
                        ServerCommunicationInfo.protocol,
                        ServerCommunicationInfo.baseUrl,
                        ServerCommunicationInfo.mcqList,
                        PostDataToServer.RequestMethod.GET,
                        listener);
        serverCommunication.execute(saltTopicID);
    }

   /* public String[] getPendingSchoolTestTopics() {
        String[] list = new String[mPendingSchoolTestList.length];

        for (int itemNum = 0; itemNum < mPendingSchoolTestList.length; itemNum++) {
            list[itemNum] = mPendingSchoolTestList[itemNum].getPendingSchoolTestTopic();
        }
        return list;
    }*/

}
