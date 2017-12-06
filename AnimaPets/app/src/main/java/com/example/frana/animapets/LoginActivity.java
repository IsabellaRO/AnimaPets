package com.example.frana.animapets;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by isabella on 27/10/17.
 */

public class LoginActivity extends AppCompatActivity {
    private SQL sql;
    private TextView txtCPF;
    private TextView txtSenha;
    private ImageView loginB;
    private Button cadastro;
    private Button senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        txtCPF = (TextView) findViewById(R.id.textCPF);
        txtSenha = (TextView) findViewById(R.id.textSenha);
        loginB = (ImageView) findViewById(R.id.buttonEntrar);
        cadastro = (Button) findViewById(R.id.buttonCadastrar);
        senha= (Button) findViewById(R.id.buttonSenha);
        sql = new SQL(this);
        displayData();
        createUsers();

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }

        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.google.com.br"));
                startActivity(intent);
            }
        });

        senha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.google.com.br"));
                startActivity(intent);
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
                    sharedPreferenceCPF(Senha,CPF);
                    startActivity(id);
                    Toast.makeText(getApplicationContext(), "user: " + enter_user.getNome().toString(), Toast.LENGTH_SHORT);
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
        User amanda = new User("Amanda Soares Santos","Rua Ática",500,"","04634042","São Paulo","SP","56782340","991234321","testeamanda@mail.com","63237001406","Max","","03/2014","14","Boxer","Medio","a123456","1");
        User joana = new User("Joana da Silva Xavier","Rua Dom Viçoso",60,"","04303001","São Paulo","SP","37462981","991234321","testejoana@mail.com","17855462287",	"Amy","","02/2016","6","lhasa","Pequeno","j123456","2");
        User joao = new User("João Paulo Sheffer","Rua Conselheiro Saraiva",600,"apto 306","02037020","São Paulo","SP","59832562","991234321","testejoao@mail.com","34761052295",	"Pablo","","04/2017","9","SRD","Medio","jo123456","3");
        User livia = new User("Livia Rubens Paiva","Alameda Santos",741,"apto 801","01419001","São Paulo","SP","58980123","991234321","testelivia@mail.com.br","21099856230",	"Snow","Snow","05/2015","7","Poodle","Pequeno","l123456","4");
        User maria = new User("Maria Julia Coelho",	"Avenida Paulista",	1865,	"apto 212",	"01311200",	"São Paulo", 	"SP",	"55667788",	"991234321",	"testemaria@mail.com",	"27384234859",	"Lionel",	"Lion",	"07/2013",	"18",	"Golden Retriever",	"Grande"	,"m123456","5");
        User tatiana = new User("Tatiana Castelo Branco","Rua Serra do Japi",340,"","03309000","São Paulo","SP",	"32327788",	"991234321","testetatiana@mail.com"	,"02125086360"	,"Lili","",	"10/2013","6","SRD","Pequeno","t123456","6");
        User sabrina = new User("Sabrina de Souza","Rua Eloi Cerqueira",400,"",	"03062010","São Paulo",	"SP",	"33001234"	,"991234321"	,"testesabrina@mail.com"	,"52746478633",	"Tadeu","Tapete","01/2010","12","Chowchow"	,"Medio",	"s123456","7");
        User ronei = new User("Ronei Fernandes Fontes","Rua Monte Alegre",502,"","05014000","São Paulo","SP","51231234","991234321","testeronei@mail.com",	"03335401824","Furia","","09/2014",	"15","Bull Terrier",	"Medio",	"r123456","8");
        sql.addClasse(amanda);
        sql.addClasse(joana);
        sql.addClasse(joao);
        sql.addClasse(livia);
        sql.addClasse(maria);
        sql.addClasse(tatiana);
        sql.addClasse(sabrina);
        sql.addClasse(ronei);

    }

    public void sharedPreferenceCPF(String senha, String name) {
        SharedPreferences sharedPreferences = getSharedPreferences("cpf_usuario",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userCPF",name);
        editor.putString("userPassword",senha);
        System.out.println("Senha: "+txtSenha.getText().toString());
        editor.apply();
        Intent i  = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
    }

    public void displayData() {
        SharedPreferences sharedPreferences = getSharedPreferences("cpf_usuario", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("userCPF","");
        String senha = sharedPreferences.getString("userPassword","");
        System.out.println("Name: "+name+"   Senha: "+senha);

        if (name != null && senha != null ) {
            txtCPF.setText(name);
            txtSenha.setText(senha);
            if(!name.equals("") && !senha.equals("")) {
                login();
            }
        }
    }

}