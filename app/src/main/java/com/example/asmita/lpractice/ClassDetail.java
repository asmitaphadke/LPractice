package com.example.asmita.lpractice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asmita on 17-10-2016.
 */
public class ClassDetail {
/*
    {
        "class_id": 7,
            "class_name": "IV"
    }
*/
    @SerializedName("class_id")
    private int mClassId;
    @SerializedName("class_name")
    private String mClassName;

    private ClassDetail() {}

    public static ClassDetail fromJson (final String serializedClassDetail) {
        //parse the Json and update the object
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(serializedClassDetail, ClassDetail.class);
    }

    public String getClassName() {
        return mClassName;
    }

    public static void loadFromServer(final Integer childClassId,
                                      final CommunicationResultListener listener) {
        PostDataToServer serverCommunication =
                new PostDataToServer(
                        ServerCommunicationInfo.protocol,
                        ServerCommunicationInfo.baseUrl,
                        ServerCommunicationInfo.classId,
                        PostDataToServer.RequestMethod.GET,
                        listener);
        serverCommunication.execute(childClassId.toString());
    }
}
