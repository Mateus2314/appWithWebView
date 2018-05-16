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

    WebView wvcresesbsite;
    WebView tabelaIradiacao;
    private Button btcalcularpv;
    private Button btcastrarirradiacao2;


    @Override
    public void onBackPressed(){
        if (wvcresesbsite.canGoBack() || tabelaIradiacao.canGoBack()){
            wvcresesbsite.goBack();
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
        wvcresesbsite = (WebView) findViewById(R.id.wvcresesbsite);
        tabelaIradiacao = (WebView) findViewById(R.id.wvtabelainrradiacao);
        btcalcularpv = (Button) findViewById(R.id.bt_calcular);

        wvcresesbsite.getSettings().setJavaScriptEnabled(true);
        wvcresesbsite.setFocusableInTouchMode(true);
        wvcresesbsite.setFocusable(true);
        wvcresesbsite.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wvcresesbsite.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wvcresesbsite.getSettings().setDomStorageEnabled(true);
        wvcresesbsite.getSettings().setDatabaseEnabled(true);
        wvcresesbsite.getSettings().setAppCacheEnabled(true);
        wvcresesbsite.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        tabelaIradiacao.getSettings().setJavaScriptEnabled(true);
        tabelaIradiacao.setFocusableInTouchMode(true);
        tabelaIradiacao.setFocusable(true);
        tabelaIradiacao.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        tabelaIradiacao.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        tabelaIradiacao.getSettings().setDomStorageEnabled(true);
        tabelaIradiacao.getSettings().setDatabaseEnabled(true);
        tabelaIradiacao.getSettings().setAppCacheEnabled(true);
        tabelaIradiacao.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        wvcresesbsite.loadUrl("http://www.cresesb.cepel.br/index.php?section=sundata");
        wvcresesbsite.setWebViewClient(new WebViewClient());

        tabelaIradiacao.loadUrl("https://1drv.ms/x/s!AmCK5A3MJcFFo3sMys51-rAKqwta");
        tabelaIradiacao.setWebViewClient(new WebViewClient());

        btcalcularpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dadosIrradiacao.this,ndu013.class));
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
