package com.apreedendo.example.mateus2314.appwithwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_dados_clientes;
    private Button bt_dados_Irradiacao;
    private Button bt_ndu013;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_dados_clientes = (Button)findViewById(R.id.bt_dados_clientes);
        bt_dados_Irradiacao = (Button)findViewById(R.id.bt_dadosIrradiacao);
        bt_ndu013 = (Button)findViewById(R.id.bt_ndu013);

        bt_dados_clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, dados_cliente.class));
            }
        });

        bt_dados_Irradiacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,dadosIrradiacao.class));
            }
        });

        bt_ndu013.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ndu013.class));
            }
        });


    }
}
