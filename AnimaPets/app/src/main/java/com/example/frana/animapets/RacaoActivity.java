package com.example.frana.animapets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
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
    ImageButton menu_btn,btn_visualizar,alterar,changebtn,cancelbtn, cancelar;
    ImageView sombra,perfill;
    ImageView dogChow1,dogChow2,pedigree1,pedigree2;
    User user;
    Dialog MyDialog;

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
        cancelar = (ImageButton) findViewById(R.id.btn_cancelar);
        sombra = (ImageView) findViewById(R.id.sombra);
        perfill = (ImageView) findViewById(R.id.perfilImageRac);
        user = sql.selecionarCliente(lhi);
        txt_nome.setText("Ola, " + user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());
        String imageName = "perfil"+user.getImagem_de_perfil().toString();
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        perfill.setImageResource(resID);
        dogChow1 = (ImageView) findViewById(R.id.dogchow1);
        dogChow2 = (ImageView) findViewById(R.id.dogchow2);
        pedigree1 = (ImageView) findViewById(R.id.pedigree1);
        pedigree2 = (ImageView) findViewById(R.id.pedigree2);
        int rac = Global.qual_rac;
        changeRac();



        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MycustomDialog();
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

        cancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sombra.setVisibility(View.VISIBLE);
                    btn_visualizar.setVisibility(View.VISIBLE);
                }
            });


    }
    void goToMain(){
        finish();

    }
    void changeRac() {
        pedigree2.setVisibility(View.INVISIBLE);
        pedigree1.setVisibility(View.INVISIBLE);
        dogChow1.setVisibility(View.INVISIBLE);
        dogChow2.setVisibility(View.INVISIBLE);
        if (Global.qual_rac == 0) {
            pedigree1.setVisibility(View.VISIBLE);
            dogChow2.setVisibility(View.VISIBLE);
        }
        else {
            pedigree2.setVisibility(View.VISIBLE);
            dogChow1.setVisibility(View.VISIBLE);
        }
    }
    public void MycustomDialog() {
        MyDialog = new Dialog(RacaoActivity.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.popup_layout);
        MyDialog.setTitle("Confirmação");

        changebtn = (ImageButton) MyDialog.findViewById(R.id.changebtn);
        cancelbtn = (ImageButton) MyDialog.findViewById(R.id.cancelbtn);

        changebtn.setEnabled(true);
        cancelbtn.setEnabled(true);

        changebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.qual_rac== 0) {
                    Global.qual_rac = 1;
                }
                else{
                    Global.qual_rac = 0;
                }
                Intent i = new Intent(getApplicationContext(),RacaoActivity.class);
                i.putExtra("user", user.getCodigo());
                startActivity(i);
                finish();
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.cancel();
                sombra.setVisibility(View.VISIBLE);
                btn_visualizar.setVisibility(View.VISIBLE);
            }
        });
        MyDialog.show();
    }


}
