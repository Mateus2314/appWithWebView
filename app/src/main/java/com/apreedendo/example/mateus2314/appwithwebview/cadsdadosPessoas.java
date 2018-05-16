package com.apreedendo.example.mateus2314.appwithwebview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class cadsdadosPessoas extends AppCompatActivity {

    ProgressBar superProgressBarmudar;
    ImageView superImageViewDados;
    WebView superWebViewMudar;
    Button superbuttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadsdados_pessoas);

        superProgressBarmudar = (ProgressBar)findViewById(R.id.myProgressBardados);
        superImageViewDados = (ImageView)findViewById(R.id.myImageViewDados);
        superWebViewMudar = (WebView)findViewById(R.id.wbtabeladadosmudar);
        superbuttonVoltar = (Button)findViewById(R.id.Btvoltardados);

        superProgressBarmudar.setMax(100);

        superWebViewMudar.loadUrl("https://docs.google.com/spreadsheets/d/12co1V3TCZpdEm9wmr8GgNY1Nm_w5zjlA6lk8pXTcmig/edit?usp=sharing");
        superWebViewMudar.getSettings().setJavaScriptEnabled(true);
        superWebViewMudar.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                superProgressBarmudar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                superImageViewDados.setImageBitmap(icon);
            }
        });

     superbuttonVoltar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(cadsdadosPessoas.this,dados_cliente.class));
         }
     });
    }
}
