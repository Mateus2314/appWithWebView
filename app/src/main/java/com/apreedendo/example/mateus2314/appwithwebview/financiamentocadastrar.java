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

public class financiamentocadastrar extends AppCompatActivity {

    ProgressBar superProgressBarmudarfin;
    ImageView superImageViewmudarfin;
    WebView superWbmudarfin;
    private Button superbuttonmudarfin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financiamentocadastrar);

        superProgressBarmudarfin = (ProgressBar)findViewById(R.id.myProgressBardad);
        superImageViewmudarfin = (ImageView)findViewById(R.id.myImageViewDd);
        superWbmudarfin = (WebView)findViewById(R.id.wbmudarfinanciamento);
        superbuttonmudarfin = (Button)findViewById(R.id.btvoltarfinanciamentocadastro);

        superProgressBarmudarfin.setMax(100);

        superWbmudarfin.loadUrl("https://docs.google.com/spreadsheets/d/1HXyrjdmR0s9geE7RXfrcUC20Vpv5sg0CxyDLBLAPA6I/edit?usp=sharing");
        superWbmudarfin.getSettings().setJavaScriptEnabled(true);
        superWbmudarfin.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                superProgressBarmudarfin.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                superImageViewmudarfin.setImageBitmap(icon);
            }
        });

        superbuttonmudarfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(financiamentocadastrar.this,financiamento.class));
            }
        });

    }
}
