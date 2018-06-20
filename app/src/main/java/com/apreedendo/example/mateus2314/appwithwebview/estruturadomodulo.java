package com.apreedendo.example.mateus2314.appwithwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class estruturadomodulo extends AppCompatActivity {

    WebView wbestruturapv;
    private Button btvoltarestrutura;

    @Override
    public void onBackPressed(){
        if(wbestruturapv.canGoBack()){
            wbestruturapv.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estruturadomodulo);

        wbestruturapv = (WebView)findViewById(R.id.wbestruturapv);
        btvoltarestrutura = (Button)findViewById(R.id.bt_voltarestruturafoto);
        wbestruturapv.getSettings().setJavaScriptEnabled(true);
        wbestruturapv.setWebViewClient(new AppWebViewClients());
        wbestruturapv.setFocusableInTouchMode(true);
        wbestruturapv.setFocusable(true);
        wbestruturapv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wbestruturapv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wbestruturapv.getSettings().setDomStorageEnabled(true);
        wbestruturapv.getSettings().setDatabaseEnabled(true);
        wbestruturapv.getSettings().setAppCacheEnabled(true);
        wbestruturapv.getSettings().setUseWideViewPort(true);
        wbestruturapv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        btvoltarestrutura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(estruturadomodulo.this, listademateriais.class));
            }
        });

        wbestruturapv.loadUrl("https://drive.google.com/file/d/1t4P_ApAx7GaMiat7GhVIu3CzATVyjQj1/view?usp=sharing");
        wbestruturapv.setWebViewClient(new WebViewClient());

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
