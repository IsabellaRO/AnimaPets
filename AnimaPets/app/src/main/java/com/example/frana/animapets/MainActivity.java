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
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#91f58a"));
        getSupportActionBar().hide();
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_raca = (TextView) findViewById(R.id.txt_raca);
        imageView = (ImageView) findViewById(R.id.imageView);
        btn_gotoVitrine = (Button) findViewById(R.id.btn_gotoVitrine);
        atualBasket = (RelativeLayout) findViewById(R.id.coming_basket);
        nextBasket = (RelativeLayout) findViewById(R.id.next_basket);
        spinner = (Spinner) findViewById(R.id.spinner);
        User user = sql.selecionarCliente(lhi);
        atualBasket.setBackgroundColor(Color.LTGRAY);
        nextBasket.setBackgroundColor(Color.parseColor("#ccf2c9"));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dropdownmain,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("Vantagens")) {
                    Toast.makeText(getApplicationContext(),"HUEHUE",Toast.LENGTH_LONG).show();
                }


                else if (spinner.getSelectedItem().toString().equals("Logout")){
                    SharedPreferences sharedPreferences = getSharedPreferences("cpf_usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userPassword","");
                    editor.apply();
                    Intent log = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(log);
                    finish();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
