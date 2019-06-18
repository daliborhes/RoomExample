package com.daliborhes.roomsample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Dalibor J. Stanković on 17.06.2019.
 */

public class WordRepository {

    private WordDAO wordDAO;
    private LiveData<List<Word>> allWords;

    public WordRepository(Application application) {
        WordRoomDatabase db =WordRoomDatabase.getDatabase(application);
        wordDAO = db.wordDAO();
        allWords = wordDAO.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(wordDAO).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDAO mAsyncTaskDao;

        public insertAsyncTask(WordDAO wordDAO) {
            mAsyncTaskDao = wordDAO;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}
