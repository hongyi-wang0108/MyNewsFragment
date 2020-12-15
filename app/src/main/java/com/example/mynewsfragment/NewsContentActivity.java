package com.example.mynewsfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {
    private String title;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        //ContentMainTwo m = (ContentMainTwo) getSupportFragmentManager().findFragmentById(R.id.content_two_main_fragment);
        ContentMainTwo m = (ContentMainTwo) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        m.refresh(title,content);
    }
    public static  void actionStart(Context c,String mtitle, String mcontent){
        Intent i = new Intent(c,NewsContentActivity.class);
        i.putExtra("title",mtitle);
        i.putExtra("content",mcontent);
        c.startActivity(i);
    }
}