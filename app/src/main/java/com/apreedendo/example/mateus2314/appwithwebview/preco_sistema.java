package com.apreedendo.example.mateus2314.appwithwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class preco_sistema extends AppCompatActivity {

    WebView wbprecosistema;
    private Button btvoltarmainpreco;
    private Button btfinanciamento;

    @Override
    public void onBackPressed(){
        if (wbprecosistema.canGoBack()){
            wbprecosistema.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preco_sistema);

        wbprecosistema = (WebView) findViewById(R.id.wbprecodosistema);
        btfinanciamento = (Button) findViewById(R.id.btfinanciamento);
        btvoltarmainpreco = (Button) findViewById(R.id.btvoltarmainCalcular);
        wbprecosistema.getSettings().setJavaScriptEnabled(true);
        wbprecosistema.setWebViewClient(new AppWebViewClients());
        wbprecosistema.setFocusableInTouchMode(true);
        wbprecosistema.setFocusable(true);
        wbprecosistema.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wbprecosistema.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wbprecosistema.getSettings().setDomStorageEnabled(true);
        wbprecosistema.getSettings().setDatabaseEnabled(true);
        wbprecosistema.getSettings().setAppCacheEnabled(true);
        wbprecosistema.getSettings().setUseWideViewPort(true);
        wbprecosistema.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        wbprecosistema.loadUrl("https://docs.google.com/spreadsheets/d/1kNauQPvnpaXyMTh1W8tLTQFQ2R_mr_am6OAFCwqnksg/edit?usp=sharing");
        wbprecosistema.setWebViewClient(new WebViewClient());

        btvoltarmainpreco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(preco_sistema.this,MainActivity.class));
            }
        });

        btfinanciamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(preco_sistema.this, financiamento.class ));
            }
        });

    }

    public class AppWebViewClients extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);

        }
    }

}
