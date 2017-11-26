package com.example.frana.animapets;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isabella on 30/10/17.
 */

public class VitrineActivity extends AppCompatActivity {
    private TextView txtSearch;
    private TextView ImageBox;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<List_vitrine_cards> list_vitrine_cards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_vitrine1);
        getSupportActionBar().hide();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list_vitrine_cards = setList_vitrine_cards();
        adapter = new RecyclerViewAdapter(list_vitrine_cards,this);
        recyclerView.setAdapter(adapter);


    }


    private List<List_vitrine_cards> setList_vitrine_cards() {
        List<List_vitrine_cards> list_vitrine_cardsa = new ArrayList<>();

        String imageName = "whiskas";
            int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards1 = new List_vitrine_cards("whyskas R$ 52,90  \n" +
                "DESCRIÇÃO:Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam Nam tempor velit c", resID);

        imageName = "arranhador";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards2 = new List_vitrine_cards("arranhador R$87,90\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam", resID);

        imageName = "kelddog";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards3 = new List_vitrine_cards("keldog R$22,90\n" +
                "DESCRIÇÃO :Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam\n", resID);

        imageName = "pelucia_caes";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards4 = new List_vitrine_cards("Pelucia caes 19,90  \n" +
                "DESCRIÇÃO :Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam", resID);

        imageName = "comedouro_de_inox";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards5 = new List_vitrine_cards("comedouro_de_inox 11,90\n" +
                "DESCRIÇÃO :Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam", resID);

        imageName = "comedouroebebedouro";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards6 = new List_vitrine_cards("comedouro e bebedouro dual 119,90\n" +
                "DESCRIÇÃO :Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam", resID);

        imageName = "coleira_anti_pulgas";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards7 = new List_vitrine_cards("coleira_anti_pulgas R$149,00\n" +
                "DESCRIÇÃO :Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam", resID);

        imageName = "perfume_femeas";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards8 = new List_vitrine_cards("perfume pet femea 10,71\n" +
                "DESCRIÇÃO :Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam\n", resID);

        imageName = "shampoo_neutro";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards9 = new List_vitrine_cards("shampoo pet neutro R$ 38,61\n" +
                "DESCRIÇÃO :Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam", resID);

        imageName = "luvas";
        resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        List_vitrine_cards list_vitrine_cards10 = new List_vitrine_cards("luvas R$12,90\n" +
                "DESCRIÇÃO : Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam.\n" +
                "Nam tempor velit consequat,\n" +
                "maximus ante id, iaculis diam. ", resID);

        list_vitrine_cardsa.add(list_vitrine_cards1);
        list_vitrine_cardsa.add(list_vitrine_cards2);
        list_vitrine_cardsa.add(list_vitrine_cards3);
        list_vitrine_cardsa.add(list_vitrine_cards4);
        list_vitrine_cardsa.add(list_vitrine_cards5);
        list_vitrine_cardsa.add(list_vitrine_cards6);
        list_vitrine_cardsa.add(list_vitrine_cards7);
        list_vitrine_cardsa.add(list_vitrine_cards8);
        list_vitrine_cardsa.add(list_vitrine_cards9);
        list_vitrine_cardsa.add(list_vitrine_cards10);

        return list_vitrine_cardsa;
    }

}