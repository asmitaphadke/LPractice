package com.example.asmita.lpractice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Asmita on 27-09-2016.
 * Object of MCQ class holds the Information about
 * a MCQ, for the selected Test, received from the Server.

 */

/* JSON format for MCQ question
 {
    "qbmcq_id": 29906,
    "qbmain_id": 231040,
    "question_text": "The numerator of fraction 3/7 is ",
    "qbmcq_option1": "3",
    "qbmcq_option2": "7",
    "qbmcq_option3": "4",
    "qbmcq_option4": "10",
    "qbmcq_option5": "",
    "qbmcq_option6": "",
    "answer_text": null,
    "question_upload_file": ""
  }
 */
public class MCQ {

    @SerializedName("qbmcq_id")
    private int mMCQId;
    @SerializedName("qbmain_id")
    private String mMainID;
    @SerializedName("question_text")
    private String mMCQQuestionText;
    @SerializedName("qbmcq_option1")
    private String mMCQOption1;
    @SerializedName("qbmcq_option2")
    private String mMCQOption2;
    @SerializedName("qbmcq_option3")
    private String mMCQOption3;
    @SerializedName("qbmcq_option4")
    private String mMCQOption4;
    @SerializedName("qbmcq_option5")
    private String mMCQOption5;
    @SerializedName("qbmcq_option6")
    private String mMCQOption6;
    @SerializedName("answer_text")
    private String mAnswerText;
    @SerializedName("question_upload_file")
    private String mQuestionUploadFile;

    private MCQ() {}

    @Override
    public String toString() {
        return "MCQData{" +
                "mMCQId=" + mMCQId +
                ", mMainID='" + mMainID + '\'' +
                ", mMCQQuestionText='" + mMCQQuestionText + '\'' +
                ", mMCQOption1='" + mMCQOption1 + '\'' +
                ", mMCQOption2='" + mMCQOption2 + '\'' +
                ", mMCQOption3='" + mMCQOption3 + '\'' +
                ", mMCQOption4='" + mMCQOption4 + '\'' +
                ", mMCQOption5='" + mMCQOption5 + '\'' +
                ", mMCQOption6='" + mMCQOption6 + '\'' +
                ", mAnswerText='" + mAnswerText + '\'' +
                ", mQuestionUploadFile='" + mQuestionUploadFile +

                '}';
    }


    /*public String getPendingSchoolTestTopic() {
        return mTopicName;
    }*/
}

