package com.example.frana.animapets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    TextView txt_nome,txt_raca;
    ImageView imageView;
    RelativeLayout atualBasket,nextBasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        imageView = (ImageView) findViewById(R.id.imageView);
        atualBasket = (RelativeLayout) findViewById(R.id.coming_basket);
        nextBasket = (RelativeLayout) findViewById(R.id.next_basket);
        User user = sql.selecionarCliente(lhi);
        atualBasket.setBackgroundColor(Color.LTGRAY);
        nextBasket.setBackgroundColor(Color.parseColor("#91f58a"));




        txt_nome.setText("Ola, "+user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());
    }
}
