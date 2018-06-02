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

public class ndu013 extends AppCompatActivity {

    WebView wbndu013;
    private Button btvoltarmainndu13;

    @Override
    public void onBackPressed(){
        if (wbndu013.canGoBack()){
            wbndu013.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndu013);

        wbndu013 = (WebView)findViewById(R.id.wbndu13);
        btvoltarmainndu13 = (Button)findViewById(R.id.btvoltarmainndu13);
        wbndu013.getSettings().setJavaScriptEnabled(true);
        wbndu013.setWebViewClient(new AppWebViewClients());
        wbndu013.setFocusableInTouchMode(true);
        wbndu013.setFocusable(true);
        wbndu013.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wbndu013.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wbndu013.getSettings().setDomStorageEnabled(true);
        wbndu013.getSettings().setDatabaseEnabled(true);
        wbndu013.getSettings().setAppCacheEnabled(true);
        wbndu013.getSettings().setUseWideViewPort(true);
        wbndu013.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        btvoltarmainndu13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ndu013.this, MainActivity.class));
            }
        });

        wbndu013.loadUrl("https://drive.google.com/file/d/1oBprhuQ3K-ufXz7RMFTs1tN8FNKqXS43/view?usp=sharing");
        wbndu013.setWebViewClient(new WebViewClient());
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
