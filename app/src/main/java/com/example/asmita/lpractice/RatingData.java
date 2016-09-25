package com.example.asmita.lpractice;

/**
     * Created by Asmita on 25-09-2016.
*/
public class RatingData {
        private final String mChapterName;
        private final String mRating;

        RatingData(final String chaptername,
                    final String rating) {
            mChapterName = chaptername;
            mRating = rating;

        }
    public String getChapterName() {
        return mChapterName;
    }
    public String getRating() {
        return mRating;
    }
}
