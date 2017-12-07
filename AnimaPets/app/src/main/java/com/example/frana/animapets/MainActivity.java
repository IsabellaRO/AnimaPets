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
    ImageButton btn_gotoVitrine;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        btn_gotoVitrine = (ImageButton) findViewById(R.id.btnVitrine);
        user = sql.selecionarCliente(lhi);
        txt_nome.setText("Ola, "+user.getNome_pet());
        txt_raca.setText(user.getRaca_pet());
        spinner = (Spinner) findViewById(R.id.spin_men);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                }
                else if (position == 2) {
                    goToRacao();
                    spinner.setSelection(0);

                }

                else if (position == 8) {
                    SharedPreferences sharedPreferences = getSharedPreferences("cpf_usuario",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userCPF","");
                    editor.putString("userPassword","");
                    editor.apply();
                    finish();
                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                    spinner.setSelection(0);

                }else{
                    nImplement();
                    spinner.setSelection(0);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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
