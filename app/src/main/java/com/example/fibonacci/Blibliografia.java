package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Blibliografia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blibliografia);

        WebView wv_b = findViewById( R.id.wv_bibl );
        wv_b.loadUrl("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
    }
}
