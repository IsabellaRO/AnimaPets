package com.example.frana.animapets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    User user;
    TextView txt_nome,txt_raca;
    ImageButton btn_gotoVitrine,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#91f58a"));
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        btn_gotoVitrine = (ImageButton) findViewById(R.id.btnVitrine);
        user = sql.selecionarCliente(lhi);
        txt_nome.setText("Ola, "+user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());
        menu = (ImageButton) findViewById(R.id.btnMenu);

        btn_gotoVitrine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVitrine();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRacao();
            }
        });


    }


    void goToVitrine() {
        Intent i = new Intent(getApplicationContext(),VitrineActivity.class);
        startActivity(i);
    }

    void goToRacao() {
        Intent i = new Intent(getApplicationContext(),RacaoActivity.class);
        i.putExtra("user", user.getCodigo());
        startActivity(i);
    }

    void nImplement() {
        Intent i = new Intent(getApplicationContext(),N_implementada.class);
        startActivity(i);

    }
}
