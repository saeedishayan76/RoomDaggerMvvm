package com.example.room.utils;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room.model.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
     void insertUser(Word word);

    @Query("SELECT * FROM tbl_word")
    LiveData<List<Word>> getAllWords();

}
