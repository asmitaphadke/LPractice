package com.example.asmita.lpractice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Asmita on 13-10-2016.
 */

/* JSON
{
  "board_id": 3,
  "board_name": "SSC"
}
 */
public class BoardDetails {
    @SerializedName("board_id")
    private Integer mBoardID;
    @SerializedName("board_name")
    private String mBoardName;

    private BoardDetails(){}

    public static BoardDetails fromJson(String result) {
        //parse the Json and update the object
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(result, BoardDetails.class);
    }

    @Override
    public String toString() {
        return "BoardDetails{" +
                "mBoardID=" + mBoardID +
                ", mBoardName='" + mBoardName + '\'' +
                '}';
    }

    public static void loadFromServer(Integer childBoardId, CommunicationResultListener listener) {
        PostDataToServer serverCommunication =
                new PostDataToServer(
                        ServerCommunicationInfo.protocol,
                        ServerCommunicationInfo.baseUrl,
                        ServerCommunicationInfo.boardId,
                        PostDataToServer.RequestMethod.GET,
                        listener);
        serverCommunication.execute(childBoardId.toString());
    }

    public String getBoardName() {
        return mBoardName;
    }
}
