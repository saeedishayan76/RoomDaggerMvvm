package com.example.room.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.room.utils.WordDao;
import com.example.room.utils.WordDataBase;
import com.example.room.model.Word;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> wordLiveData;

    public WordRepository(Application context) {
        WordDataBase wordDataBase = WordDataBase.getInstance(context);
        wordDao = wordDataBase.wordDao();
        wordLiveData = wordDao.getAllWords();
    }

    public LiveData<List<Word>> getWordLiveData() {
        return wordLiveData;
    }

    public void insert(Word word)
    {
        new InsertWordAsyncTask(wordDao).execute(word);
    }

    private static class InsertWordAsyncTask extends AsyncTask<Word,Void,Void>
    {
        private WordDao wordDao;

        public InsertWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertUser(words[0]);
            return null;
        }
    }
}
