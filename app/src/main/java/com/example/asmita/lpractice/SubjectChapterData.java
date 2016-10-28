package com.example.asmita.lpractice;

import java.util.List;

/**
 * Created by Asmita on 27-09-2016.
 */
public class SubjectChapterData {
    private final String mSubjectName;
    private final List<String> mSubjectChapters;

    SubjectChapterData(final String subjectname,
            final List<String> subjectchapters) {
        mSubjectName = subjectname;
        mSubjectChapters = subjectchapters;

    }
    public List<String> getmSubjectChapters() {
        return mSubjectChapters;
    }

    public String getmSubjectName() {
        return mSubjectName;
    }
}


