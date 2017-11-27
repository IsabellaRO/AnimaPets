package com.example.frana.animapets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by frana on 27/11/2017.
 */

public class N_implementada extends AppCompatActivity{

    private Button volts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nimplementada);
        getSupportActionBar().hide();
        volts = (Button) findViewById(R.id.btn_volts);


        volts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finhishAct();
            }
        });
    }

    void finhishAct() {
        finish();
    }

}
