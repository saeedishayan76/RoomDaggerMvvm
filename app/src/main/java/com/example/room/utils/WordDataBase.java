package com.example.room.utils;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.room.model.Word;

@Database(entities = {Word.class},version = 4,exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {

     public abstract WordDao wordDao();

      private static WordDataBase w = null;

    public static WordDataBase getInstance(Application context) {
        if (w == null)
        {
            w = Room.databaseBuilder(context,WordDataBase.class,"sample")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return w;
    }




}
