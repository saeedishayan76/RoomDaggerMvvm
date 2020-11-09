package com.example.room.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.room.model.Word;
import com.example.room.repository.WordRepository;

import java.util.List;

import javax.inject.Inject;

public class WordViewModel extends ViewModel {
    public WordRepository wordRepository;
    private LiveData<List<Word>> wordList;
    private static final String TAG = "WordViewModel";

    @Inject
    public WordViewModel( Application application) {
        Log.i(TAG, "WordView: "+application);
        wordRepository = new WordRepository(application);
        wordList = wordRepository.getWordLiveData();
//        wordRepository = new WordRepository(application);
//        wordList = wordRepository.getWordLiveData();
    }


    public LiveData<List<Word>> getWordList() {
        return wordList;
    }

    public void insert(Word word)
    {
        wordRepository.insert(word);
    }
}
