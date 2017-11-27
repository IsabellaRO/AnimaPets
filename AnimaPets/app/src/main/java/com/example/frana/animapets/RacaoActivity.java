package com.example.frana.animapets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by isabella on 13/11/17.
 */

public class RacaoActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    TextView txt_nome, txt_raca;
    ImageButton menu_btn;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racao);
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        menu_btn = (ImageButton) findViewById(R.id.btnHome);
        user = sql.selecionarCliente(lhi);
        txt_nome.setText("Ola, " + user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });


    }
    void goToMain(){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.putExtra("user", user.getCodigo());

        startActivity(i);
        finish();

    }
}
