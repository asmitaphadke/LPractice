package com.example.asmita.lpractice;

/**
 * Created by Asmita on 02-10-2016.
 */
public interface CommunicationResultListener {
    void onSuccess(final String result);
    void onFailure(final Exception e);
}
