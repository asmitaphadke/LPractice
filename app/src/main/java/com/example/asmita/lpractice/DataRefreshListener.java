package com.example.asmita.lpractice;

/**
 * Created by Asmita on 19-10-2016.
 */
public interface DataRefreshListener {
    enum TYPE {
        BOARD_INFO,
        CLASS_INFO,
        MCQ_INFO
    }
    void onNewDataAvailable(final TYPE type);
}
