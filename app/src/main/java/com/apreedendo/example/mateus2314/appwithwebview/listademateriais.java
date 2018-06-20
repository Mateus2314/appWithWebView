package com.apreedendo.example.mateus2314.appwithwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class listademateriais extends AppCompatActivity {

    WebView weblistmateriais;
    private Button btvoltardalistademateriais;
    private Button btestrutura;

    @Override
    public void onBackPressed(){
        if (weblistmateriais.canGoBack()){
            weblistmateriais.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listademateriais);

        weblistmateriais = (WebView) findViewById(R.id.wblistamateriais);
        weblistmateriais.getSettings().setJavaScriptEnabled(true);
        weblistmateriais.setWebViewClient(new AppWebViewCliente());
        weblistmateriais.setFocusableInTouchMode(true);
        weblistmateriais.setFocusable(true);
        weblistmateriais.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        weblistmateriais.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        weblistmateriais.getSettings().setDomStorageEnabled(true);
        weblistmateriais.getSettings().setDatabaseEnabled(true);
        weblistmateriais.getSettings().setAppCacheEnabled(true);
        weblistmateriais.getSettings().setUseWideViewPort(true);
        weblistmateriais.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        weblistmateriais.loadUrl("https://docs.google.com/spreadsheets/d/1kGkzubNSd5aVoIEk8ajUxVkO-CuU7WPiq0mLhPXPccE/edit?usp=sharing");
        weblistmateriais.setWebViewClient(new WebViewClient());

        btestrutura = (Button)findViewById(R.id.btdescricaoestruturas);
        btvoltardalistademateriais = (Button)findViewById(R.id.btvoltardalistademateriais);

        btvoltardalistademateriais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(listademateriais.this,financiamento.class));
            }
        });

        btestrutura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(listademateriais.this, estruturadomodulo.class));
            }
        });


    }

    public class AppWebViewCliente extends WebViewClient{
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
