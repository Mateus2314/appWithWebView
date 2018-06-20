package com.apreedendo.example.mateus2314.appwithwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class producaopv extends AppCompatActivity {

    WebView wbproducaopv;
    private Button btvoltarproducaopv;

    @Override
    public void onBackPressed(){
        if (wbproducaopv.canGoBack()){
            wbproducaopv.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producaopv);

        wbproducaopv = (WebView)findViewById(R.id.wbproducaopv);
        btvoltarproducaopv = (Button)findViewById(R.id.btvoltarproducaopv);
        wbproducaopv.getSettings().setJavaScriptEnabled(true);
        wbproducaopv.setWebViewClient(new AppWebViewClients());
        wbproducaopv.setFocusableInTouchMode(true);
        wbproducaopv.setFocusable(true);
        wbproducaopv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wbproducaopv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wbproducaopv.getSettings().setDomStorageEnabled(true);
        wbproducaopv.getSettings().setDatabaseEnabled(true);
        wbproducaopv.getSettings().setAppCacheEnabled(true);
        wbproducaopv.getSettings().setUseWideViewPort(true);
        wbproducaopv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        btvoltarproducaopv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(producaopv.this, financiamento.class));
            }
        });

        wbproducaopv.loadUrl("https://docs.google.com/spreadsheets/d/1VmafbVw3zFQ0IVJyzoFR29Y-XqWaB0RwOO-3-GtV8r4/edit?usp=sharing");
        wbproducaopv.setWebViewClient(new WebViewClient());

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
