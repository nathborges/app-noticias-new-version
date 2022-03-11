package com.ibm.newsapp;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class SaibaMaisActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle extras = getIntent().getExtras();
            String url = extras.getString(UltimasNoticiasActivity.URL);

            WebView theWebPage = new WebView(this);
            theWebPage.getSettings().setJavaScriptEnabled(true);
            setContentView(theWebPage);
            theWebPage.loadUrl(url);
        }
    }