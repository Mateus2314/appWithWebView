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

public class dados_cliente extends AppCompatActivity {

    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    WebView webcresesb;
    private Button voltarmainInr;
    private Button seguircreseb;

    @Override
    public void onBackPressed(){
        if(webcresesb.canGoBack()){
            webcresesb.goBack();
        }else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_cliente);

        webcresesb = (WebView) findViewById(R.id.wbtabeladados);
        webcresesb.getSettings().setJavaScriptEnabled(true);
        webcresesb.setWebViewClient(new AppWebViewClients());
        webcresesb.setFocusableInTouchMode(true);
        webcresesb.setFocusable(true);
        webcresesb.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webcresesb.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webcresesb.getSettings().setDomStorageEnabled(true);
        webcresesb.getSettings().setDatabaseEnabled(true);
        webcresesb.getSettings().setAppCacheEnabled(true);
        webcresesb.getSettings().setUseWideViewPort(true);
        webcresesb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webcresesb.loadUrl("https://docs.google.com/spreadsheets/d/12co1V3TCZpdEm9wmr8GgNY1Nm_w5zjlA6lk8pXTcmig/edit?usp=sharing");
        webcresesb.setWebViewClient(new WebViewClient());


        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        voltarmainInr = (Button)findViewById(R.id.bt_voltar);
        seguircreseb = (Button)findViewById(R.id.btseguir);

        seguircreseb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dados_cliente.this, cadsdadosPessoas.class));
            }
        });

        voltarmainInr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dados_cliente.this,MainActivity.class));
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


    void getLocation(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }else{

            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null){
                double latti = location.getLatitude();
                double longi = location.getLongitude();

                ((EditText)findViewById(R.id.edLatitude)).setText(" "+ latti);
                ((EditText)findViewById(R.id.edlong)).setText(" " + longi);
            }else {
                ((EditText)findViewById(R.id.edLatitude)).setText("Unble to find correct Location.");
                ((EditText)findViewById(R.id.edlong)).setText("Unble to find correct Location.");
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permission, grantResults);

        switch (requestCode){
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}

