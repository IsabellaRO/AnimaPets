package com.example.frana.animapets;

import android.app.Activity;
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
    ImageView dogChow1,dogChow2,pedigree1,pedigree2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_layout);
        getSupportActionBar().hide();
        changebtn = (ImageButton) findViewById(R.id.changebtn);
        cancelbtn = (ImageButton) findViewById(R.id.cancelbtn);
        dogChow1 = (ImageView) findViewById(R.id.dogchow1);
        dogChow2 = (ImageView) findViewById(R.id.dogchow2);
        pedigree1 = (ImageView) findViewById(R.id.pedigree1);
        pedigree2 = (ImageView) findViewById(R.id.pedigree2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.6));
    }

    changebtn.OnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeRac();
        }
    });

    cancelbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
        goToRacao();
        }
    });

    void changeRac() {
        if (pedigree1.getVisibility() == View.INVISIBLE) {
            pedigree1.setVisibility(View.VISIBLE);
            pedigree2.setVisibility(View.INVISIBLE);
            dogChow2.setVisibility(View.VISIBLE);
            dogChow1.setVisibility(View.INVISIBLE);
        }
        else {
            pedigree2.setVisibility(View.VISIBLE);
            pedigree1.setVisibility(View.INVISIBLE);
            dogChow1.setVisibility(View.VISIBLE);
            dogChow2.setVisibility(View.INVISIBLE);
        }
    }

    void goToRacao(){
        finish();

    }



}
