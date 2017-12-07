package com.example.frana.animapets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by isabella on 13/11/17.
 */

public class RacaoActivity extends AppCompatActivity {
    int lhi;
    SQL sql;
    TextView txt_nome, txt_raca;
    ImageButton menu_btn,btn_visualizar,alterar;
    ImageView sombra,dogChow1,dogChow2,pedigree1,pedigree2,perfill;
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
        btn_visualizar = (ImageButton) findViewById(R.id.btn_visualizar);
        alterar = (ImageButton) findViewById(R.id.btn_alterar);
        sombra = (ImageView) findViewById(R.id.sombra);
        perfill = (ImageView) findViewById(R.id.perfilImageRac);
        dogChow1 = (ImageView) findViewById(R.id.dogchow1);
        dogChow2 = (ImageView) findViewById(R.id.dogchow2);
        pedigree1 = (ImageView) findViewById(R.id.pedigree1);
        pedigree2 = (ImageView) findViewById(R.id.pedigree2);
        user = sql.selecionarCliente(lhi);
        txt_nome.setText("Ola, " + user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());
        String imageName = "perfil"+user.getImagem_de_perfil().toString();
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        perfill.setImageResource(resID);

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PopUp.class));
                changeRac();
            }
        });

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });
        btn_visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sombra.setVisibility(View.INVISIBLE);
                btn_visualizar.setVisibility(View.INVISIBLE);
            }
        });


    }
    void goToMain(){
        finish();

    }

    void changeRac() {
        if (pedigree1.getVisibility() == View.INVISIBLE) {
            pedigree1.setVisibility(View.VISIBLE);
            pedigree2.setVisibility(View.INVISIBLE);
            dogChow2.setVisibility(View.VISIBLE);
            dogChow1.setVisibility(View.INVISIBLE);
            sombra.setVisibility(View.VISIBLE);
            btn_visualizar.setVisibility(View.VISIBLE);
        }
        else {
            pedigree2.setVisibility(View.VISIBLE);
            pedigree1.setVisibility(View.INVISIBLE);
            dogChow1.setVisibility(View.VISIBLE);
            dogChow2.setVisibility(View.INVISIBLE);
            sombra.setVisibility(View.VISIBLE);
            btn_visualizar.setVisibility(View.VISIBLE);
        }


    }
}
