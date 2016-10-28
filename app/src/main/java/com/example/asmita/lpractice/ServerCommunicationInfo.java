package com.example.asmita.lpractice;

/**
 * Created by Asmita on 04-10-2016.
 */
public class ServerCommunicationInfo {
    public static final String protocol = "http://";
    public static final String baseUrl = "lpstaging.in";
    //"52.76.158.251/school.letspractise.com";

    // API for getting UserInformation on Login
    public static final String loginRequestMethod = "/doApiLogin";
    // API to get BoardDetails(Board Name) for given Board ID
    public static String boardId = "/getBoardDetail";
    // API to get ClassDetails (Class Name) for given Class ID
    public static String classId = "/getClassDetail";
    // API to get list of Pending Schools Tests for given Child ID
    public static String pendingSchoolTestList = "/getPendingMcqs";
    // API to get list of MCQs for Selected Test
    public static String mcqList = "/getApiMcqsForSalt";
}
