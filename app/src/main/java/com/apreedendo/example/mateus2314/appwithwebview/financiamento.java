package com.apreedendo.example.mateus2314.appwithwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class financiamento extends AppCompatActivity {

    WebView wbfinanciamento;
    private Button btvoltarfinanciamento;
    private Button btlistademateriais;
    private Button btproducaodopv;
    private Button btcadastrarfinanciar;

    @Override
    public void onBackPressed(){
        if (wbfinanciamento.canGoBack()){
            wbfinanciamento.goBack();
        }else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financiamento);

        wbfinanciamento = (WebView) findViewById(R.id.wbfinanciamento);
        btvoltarfinanciamento = (Button) findViewById(R.id.btvoltarparalistadeprodutos);
        btlistademateriais= (Button) findViewById(R.id.btlistademateriais);
        btproducaodopv = (Button)findViewById(R.id.btproducaodosistema);
        btcadastrarfinanciar = (Button)findViewById(R.id.btmudarfinanciamento);

        wbfinanciamento.getSettings().setJavaScriptEnabled(true);
        wbfinanciamento.setWebViewClient(new AppWebViewClients());
        wbfinanciamento.setFocusableInTouchMode(true);
        wbfinanciamento.setFocusable(true);
        wbfinanciamento.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wbfinanciamento.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wbfinanciamento.getSettings().setDomStorageEnabled(true);
        wbfinanciamento.getSettings().setDatabaseEnabled(true);
        wbfinanciamento.getSettings().setAppCacheEnabled(true);
        wbfinanciamento.getSettings().setUseWideViewPort(true);
        wbfinanciamento.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        wbfinanciamento.loadUrl("https://docs.google.com/spreadsheets/d/1HXyrjdmR0s9geE7RXfrcUC20Vpv5sg0CxyDLBLAPA6I/edit?usp=sharing");
        wbfinanciamento.setWebViewClient(new WebViewClient());

        btvoltarfinanciamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(financiamento.this,preco_sistema.class));
            }
        });

        btproducaodopv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(financiamento.this,producaopv.class));
            }
        });

        btlistademateriais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(financiamento.this,listademateriais.class));
            }
        });

        btcadastrarfinanciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(financiamento.this,financiamentocadastrar.class));
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
