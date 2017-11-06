package com.example.frana.animapets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by isabella on 27/10/17.
 */

public class LoginActivity extends AppCompatActivity {
    private SQL sql;
    private TextView txtCPF;
    private TextView txtSenha;
    private Button loginB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        txtCPF = (TextView) findViewById(R.id.textCPF);
        txtSenha = (TextView) findViewById(R.id.textSenha);
        loginB = (Button) findViewById(R.id.buttonEntrar);
        sql = new SQL(this);
        //createUsers();

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }

    protected void login() {
        String CPF = txtCPF.getText().toString();
        String Senha = txtSenha.getText().toString();
        User enter_user;
        Intent id = new Intent(getApplicationContext(), MainActivity.class);
        for (int i = 1; i < 50; i++) {
            System.out.println(i);
            try{
                enter_user = sql.selecionarCliente(i);
                Toast.makeText(getApplicationContext(), "user: " + enter_user.getNome(), Toast.LENGTH_LONG);
                System.out.println(enter_user.getCpf().toString());
                if (enter_user.getCpf().toString().equals(CPF.toString()) && enter_user.getSenha().toString().equals(Senha.toString())) {
                    id.putExtra("user", enter_user.getCodigo());
                    startActivity(id);
                    Toast.makeText(getApplicationContext(), "user: " + enter_user.getNome().toString(), Toast.LENGTH_LONG);
                    finish();
                    break;

                }
            }catch (Exception e){
                System.out.println("i: "+i);
                Toast.makeText(getApplicationContext(),"CPF ou Senha Incorretos",Toast.LENGTH_LONG).show();
            }

        }

    }




    protected boolean autentication() {
        return false;
    }
    // autenticacao de acordo com a base de dados


    public void createUsers() {
        User amanda = new User("Amanda Soares Santos","Rua Ática",500,"","04634042","São Paulo","SP","56782340","991234321","testeamanda@mail.com","63237001406","Max","","03/2014","14","Boxer","Medio","a123456");
        User joana = new User("Joana da Silva Xavier","Rua Dom Viçoso",60,"","04303001","São Paulo","SP","37462981","991234321","testejoana@mail.com","17855462287",	"Amy","","02/2016","6","lhasa","Pequeno","j123456");
        User joao = new User("João Paulo Sheffer","Rua Conselheiro Saraiva",600,"apto 306","02037020","São Paulo","SP","59832562","991234321","testejoao@mail.com","34761052295",	"Pablo","","04/2017","9","SRD","Medio","jo123456");
        User livia = new User("Livia Rubens Paiva","Alameda Santos",741,"apto 801","01419001","São Paulo","SP","58980123","991234321","testelivia@mail.com.br","21099856230",	"Snow","Snow","05/2015","7","Poodle","Pequeno","l123456");
        User maria = new User("Maria Julia Coelho",	"Avenida Paulista",	1865,	"apto 212",	"01311200",	"São Paulo", 	"SP",	"55667788",	"991234321",	"testemaria@mail.com",	"27384234859",	"Lionel",	"Lion",	"07/2013",	"18",	"Golden Retriever",	"Grande"	,"m123456");
        User tatiana = new User("Tatiana Castelo Branco","Rua Serra do Japi",340,"","03309000","São Paulo","SP",	"32327788",	"991234321","testetatiana@mail.com"	,"02125086360"	,"Lili","",	"10/2013","6","SRD","Pequeno","t123456");
        User sabrina = new User("Sabrina de Souza","Rua Eloi Cerqueira",400,"",	"03062010","São Paulo",	"SP",	"33001234"	,"991234321"	,"testesabrina@mail.com"	,"52746478633",	"Tadeu","Tapete","01/2010","12","Chowchow"	,"Medio",	"s123456");
        User ronei = new User("Ronei Fernandes Fontes","Rua Monte Alegre",502,"","05014000","São Paulo","SP","51231234","991234321","testeronei@mail.com",	"03335401824","Furia","","09/2014",	"15","Bull Terrier",	"Medio",	"r123456");
        sql.addClasse(amanda);
        sql.addClasse(joana);
        sql.addClasse(joao);
        sql.addClasse(livia);
        sql.addClasse(maria);
        sql.addClasse(tatiana);
        sql.addClasse(sabrina);
        sql.addClasse(ronei);

    }


}