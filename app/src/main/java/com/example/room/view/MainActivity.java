package com.example.room.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.room.R;
import com.example.room.di.ViewModelProviderFactory;
import com.example.room.model.Word;
import com.example.room.utils.WordDao;
import com.example.room.utils.WordDataBase;
import com.example.room.viewmodel.WordViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edName;
    private static final String TAG = "MainActivity";
    WordDataBase wordDataBase;
    WordDao wordDao;



    @Inject
    ViewModelProviderFactory factory;
    WordViewModel wordViewModel;
    @Inject
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        btn = findViewById(R.id.btn);
        wordDataBase = WordDataBase.getInstance(getApplication());
        wordDao = wordDataBase.wordDao();
        edName = findViewById(R.id.ed);
//        wordViewModel = new ViewModelProvider(this,factory).get(WordViewModel.class);
//        Log.i(TAG, "onCreate: "+s);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Word word = new Word();
//                word.setWord(edName.getText().toString().trim());
//                wordViewModel.insert(word);
//                Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        wordViewModel.getWordList().observe(this, new Observer<List<Word>>() {
//            @Override
//            public void onChanged(List<Word> words) {
//                for (Word word : words)
//                {
//                    Log.i(TAG, "onChanged: "+word.getWord());
//                }
//            }
//        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word();
                word.setWord(edName.getText().toString());
                wordDao.insertUser(word);
            }
        });

        wordDao.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                for (Word word : words)
                Log.i(TAG, "onChanged: "+word.getWord());
            }
        });

      //  Log.i(TAG, "onCreate: "+wordDao.getAllWords().getValue());

    }
}