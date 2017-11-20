package com.example.frana.animapets;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    TextView txt_nome,txt_raca;
    ImageView imageView;
    RelativeLayout atualBasket,nextBasket;
    Button btn_gotoVitrine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        imageView = (ImageView) findViewById(R.id.imageView);
        btn_gotoVitrine = (Button) findViewById(R.id.btn_gotoVitrine);
        atualBasket = (RelativeLayout) findViewById(R.id.coming_basket);
        nextBasket = (RelativeLayout) findViewById(R.id.next_basket);
        User user = sql.selecionarCliente(lhi);
        atualBasket.setBackgroundColor(Color.LTGRAY);
        nextBasket.setBackgroundColor(Color.parseColor("#91f58a"));

        btn_gotoVitrine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVitrine();
            }
        });


        txt_nome.setText("Ola, "+user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());
    }


    void goToVitrine() {
        Intent i = new Intent(getApplicationContext(),VitrineActivity.class);
        startActivity(i);
    }
}
