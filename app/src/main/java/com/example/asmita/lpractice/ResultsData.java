package com.example.asmita.lpractice;

/**
 * Created by Asmita on 23-09-2016.
 */
public class ResultsData {
    private final String mActualAnswer;
    private final String mQuestion;
    private final String mExpectedAnswer;

    ResultsData(final String question,
                final String expectedAnswer,
                final String actualAnswer) {
        mQuestion = question;
        mExpectedAnswer = expectedAnswer;
        mActualAnswer = actualAnswer;
    }

    public String getActualAnswer() {
        return mActualAnswer;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getExpectedAnswer() {
        return mExpectedAnswer;
    }
}
