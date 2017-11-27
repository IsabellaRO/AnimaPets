package com.example.frana.animapets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    TextView txt_nome,txt_raca;
    ImageButton btn_gotoVitrine;

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
        User user = sql.selecionarCliente(lhi);
        txt_nome.setText("Ola, "+user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());

        btn_gotoVitrine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVitrine();
            }
        });
    }


    void goToVitrine() {
        Intent i = new Intent(getApplicationContext(),VitrineActivity.class);
        startActivity(i);
    }
}
