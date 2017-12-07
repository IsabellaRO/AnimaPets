package com.example.frana.animapets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by frana on 06/12/2017.
 */

public class PopUp extends Activity {

    ImageButton changebtn, cancelbtn;
    int lhi;
    User user;
    SQL sql;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_layout);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.6));
        changebtn = (ImageButton) findViewById(R.id.changebtn);
        cancelbtn = (ImageButton) findViewById(R.id.cancelbtn);
        sql = new SQL(this);
        lhi = (int) getIntent().getSerializableExtra("user");
        user = sql.selecionarCliente(lhi);

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
                finish();
            }
        });


    }





    void goToRacao(){
        finish();

    }



}
