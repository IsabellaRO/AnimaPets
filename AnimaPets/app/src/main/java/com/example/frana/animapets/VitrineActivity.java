package com.example.frana.animapets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by isabella on 30/10/17.
 */

public class VitrineActivity extends AppCompatActivity {
    private TextView txtSearch;
    private TextView ImageBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine);
        //txtSearch = (TextView) findViewById(R.id.searchV);
    }

    protected void search() {
        //String pesquisa = txtSearch.getText().toString();
        //fazer varredura na lista de itens
    }

}
