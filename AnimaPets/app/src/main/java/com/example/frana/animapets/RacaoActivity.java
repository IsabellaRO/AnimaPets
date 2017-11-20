package com.example.frana.animapets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by isabella on 13/11/17.
 */

public class RacaoActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    TextView txt_nome, txt_raca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racao);
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        User user = sql.selecionarCliente(lhi);


        txt_nome.setText("Ola, " + user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());


    }
}
