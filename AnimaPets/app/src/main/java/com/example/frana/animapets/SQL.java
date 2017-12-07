package com.example.frana.animapets;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SQL extends SQLiteOpenHelper {
    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CLIENTE = "bd_clientes";

    private static final String TABELA_CLIENTE = "tb_clientes";

    private static final String CODIGO_CLIENTE = "codigo";
    private static final String NOME_CLIENTE = "nome";
    private static final String ENDERECO_CLIENTE = "endereco";
    private static final String NUMERO_END_CLIENTE = "numero_end";
    private static final String COMPLEMENTO = "compelmento";
    private static final String CEP_CLIENTE = "cep";
    private static final String CIDADE_CLIENTE = "cidade";
    private static final String ESTADO_CLIENTE = "estado";
    private static final String TELEFONE_CLIENTE = "telefone";
    private static final String CELULAR_CLIENTE = "celular";
    private static final String EMAIL_CLIENTE = "email";
    private static final String CPF_CLIENTE = "CPF";
    private static final String NOME_PET_CLIENTE = "nome_pet";
    private static final String APELIDO_PET_CLIENTE = "apelido_pet";
    private static final String NASCIMENTO_PET_CLIENTE = "nescimento_pet";
    private static final String PESO_PET_CLIENTE = "peso_pet";
    private static final String RACA_PET_CLIENTE = "raca_pet";
    private static final String PORTE_PET_CLIENTE = "porte_pet";
    private static final String SENHA_CLIENTE = "senha";
    private static final String IMAGEM_PERFIL = "perfil";


    public SQL(Context context) {
        super(context, BANCO_CLIENTE, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUNA = "CREATE TABLE " + TABELA_CLIENTE + "("
                + CODIGO_CLIENTE + " INTEGER PRIMARY KEY, " + NOME_CLIENTE + " TEXT, " + ENDERECO_CLIENTE + " TEXT, " + NUMERO_END_CLIENTE + " TEXT, "
                + COMPLEMENTO + " TEXT, " + CEP_CLIENTE + " TEXT, "
                + CIDADE_CLIENTE + " TEXT, " + ESTADO_CLIENTE + " TEXT, "
                + TELEFONE_CLIENTE + " TEXT, " + CELULAR_CLIENTE + " TEXT, " +EMAIL_CLIENTE + " TEXT, " + CPF_CLIENTE + " TEXT, "
                + NOME_PET_CLIENTE + " TEXT, " + APELIDO_PET_CLIENTE + " TEXT, " + NASCIMENTO_PET_CLIENTE + " TEXT, "
                + PESO_PET_CLIENTE + " TEXT, " + RACA_PET_CLIENTE + " TEXT, " + PORTE_PET_CLIENTE + " TEXT, "
                + SENHA_CLIENTE +  " TEXT, " + IMAGEM_PERFIL + " TEXT)";

        db.execSQL(QUERY_COLUNA);



    }

    public void addClasse(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NOME_CLIENTE, String.valueOf(user.getNome()));
        values.put(ENDERECO_CLIENTE, String.valueOf(user.getEndereco()));
        values.put(NUMERO_END_CLIENTE, String.valueOf(user.getNumero_end()));
        values.put(COMPLEMENTO, String.valueOf(user.getComplemento()));
        values.put(CEP_CLIENTE, String.valueOf(user.getCep()));
        values.put(CIDADE_CLIENTE, String.valueOf(user.getCidade()));
        values.put(ESTADO_CLIENTE, String.valueOf(user.getEstado()));
        values.put(TELEFONE_CLIENTE, String.valueOf(user.getTelefone()));
        values.put(CELULAR_CLIENTE, String.valueOf(user.getCelular()));
        values.put(EMAIL_CLIENTE, String.valueOf(user.getEmail()));
        values.put(CPF_CLIENTE, String.valueOf(user.getCpf()));
        values.put(NOME_PET_CLIENTE, String.valueOf(user.getNome_pet()));
        values.put(APELIDO_PET_CLIENTE, String.valueOf(user.getApelido_pet()));
        values.put(NASCIMENTO_PET_CLIENTE, String.valueOf(user.getNascimento_pet()));
        values.put(PESO_PET_CLIENTE, String.valueOf(user.getPeso_pet()));
        values.put(RACA_PET_CLIENTE, String.valueOf(user.getRaca_pet()));
        values.put(PORTE_PET_CLIENTE, String.valueOf(user.getPorte_pet()));
        values.put(SENHA_CLIENTE, String.valueOf(user.getSenha()));
        values.put(IMAGEM_PERFIL, String.valueOf(user.getImagem_de_perfil()));

        db.insert(TABELA_CLIENTE, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    User selecionarCliente(int codigo) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_CLIENTE, new String[]{CODIGO_CLIENTE, NOME_CLIENTE, ENDERECO_CLIENTE, NUMERO_END_CLIENTE, COMPLEMENTO, CEP_CLIENTE, CIDADE_CLIENTE, ESTADO_CLIENTE, TELEFONE_CLIENTE,
        CELULAR_CLIENTE, EMAIL_CLIENTE, CPF_CLIENTE, NOME_PET_CLIENTE, APELIDO_PET_CLIENTE, NASCIMENTO_PET_CLIENTE,PESO_PET_CLIENTE, RACA_PET_CLIENTE, PORTE_PET_CLIENTE,SENHA_CLIENTE,IMAGEM_PERFIL}, CODIGO_CLIENTE + " = ?", new String[]{String.valueOf(codigo)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        //int codigo, String nome, String endereco2, int numero_end3, String complemento4, int cep5, String cidade6, String estado7, int telefone8, int celular9, String email10, int cpf11, String nome_pet12, String apelido_pet13,
        //      String nascimento_pet14, int peso_pet15, String raca_pet16, String pote_pet17, String senha18
        return new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getColumnName(17),cursor.getString(18),cursor.getString(19));
    }
}

