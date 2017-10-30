package com.example.frana.animapets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by isabella on 27/10/17.
 */

public class LoginActivity extends AppCompatActivity {
    private TextView txtCPF;
    private TextView txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtCPF = (TextView) findViewById(R.id.textCPF);
        txtSenha = (TextView) findViewById(R.id.textSenha);
    }

    protected void login(){
        String CPF = txtCPF.getText().toString();
        String Senha = txtSenha.getText().toString();
    }

    protected boolean autentication(){
        return false;
    }
    // autenticacao de acordo com a base de dados
}
