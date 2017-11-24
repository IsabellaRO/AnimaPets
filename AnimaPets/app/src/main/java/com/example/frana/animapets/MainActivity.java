package com.example.frana.animapets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    TextView txt_nome,txt_raca;
    ImageView imageView;
    RelativeLayout atualBasket,nextBasket;
    Button btn_gotoVitrine;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //getWindow().getDecorView().setBackgroundColor(Color.parseColor("#91f58a"));
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        imageView = (ImageView) findViewById(R.id.imageView);
        //btn_gotoVitrine = (Button) findViewById(R.id.btn_gotoVitrine);
        atualBasket = (RelativeLayout) findViewById(R.id.coming_basket);
        nextBasket = (RelativeLayout) findViewById(R.id.next_basket);
        User user = sql.selecionarCliente(lhi);
        txt_nome.setText("Ola, "+user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());
    }


    void goToVitrine() {
        Intent i = new Intent(getApplicationContext(),VitrineActivity.class);
        startActivity(i);
    }
}
