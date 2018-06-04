package com.apreedendo.example.mateus2314.appwithwebview;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class dadosIrradiacao extends AppCompatActivity {

    WebView tabelaIradiacao;
    private Button btcalcularpv;
    private Button btcastrarirradiacao2;


    @Override
    public void onBackPressed(){
        if (tabelaIradiacao.canGoBack()){

            tabelaIradiacao.goBack();
        }else {
            super.onBackPressed();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_irradiacao);

        btcastrarirradiacao2 = (Button) findViewById(R.id.btcadastrarirradia);
        tabelaIradiacao = (WebView) findViewById(R.id.wvtabelainrradiacao);
        btcalcularpv = (Button) findViewById(R.id.bt_calcular);



        tabelaIradiacao.getSettings().setJavaScriptEnabled(true);
        tabelaIradiacao.setFocusableInTouchMode(true);
        tabelaIradiacao.setFocusable(true);
        tabelaIradiacao.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        tabelaIradiacao.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        tabelaIradiacao.getSettings().setDomStorageEnabled(true);
        tabelaIradiacao.getSettings().setDatabaseEnabled(true);
        tabelaIradiacao.getSettings().setAppCacheEnabled(true);
        tabelaIradiacao.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        tabelaIradiacao.loadUrl("https://docs.google.com/spreadsheets/d/16_Kzbl7jr3SVy4953okRJ73vc4NYQSE9MzfdFOvAR5A/edit?usp=sharing");
        tabelaIradiacao.setWebViewClient(new WebViewClient());

        btcalcularpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dadosIrradiacao.this,MainActivity.class));
            }
        });

        btcastrarirradiacao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dadosIrradiacao.this, cadastrarIrradiacao.class));
            }
        });


    }
}
