package com.example.frana.animapets;

/**
 * Created by frana on 03/11/2017.
 */

public class User {

    public User(String nome, String endereco, int numero_end, String complemento, String cep, String cidade, String estado, String telefone, String celular, String email, String cpf, String nome_pet, String apelido_pet,
                String nascimento_pet, String peso_pet, String raca_pet, String porte_pet, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero_end = numero_end;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.cpf = cpf;
        this.nome_pet = nome_pet;
        this.apelido_pet = apelido_pet;
        this.nascimento_pet = nascimento_pet;
        this.peso_pet = peso_pet;
        this.raca_pet = raca_pet;
        this.porte_pet = porte_pet;
        this.senha = senha;
    }

    public User(int codigo, String nome, String endereco, int numero_end, String complemento, String cep, String cidade, String estado, String telefone, String celular, String email, String cpf, String nome_pet, String apelido_pet,
                String nascimento_pet, String peso_pet, String raca_pet, String porte_pet, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.numero_end = numero_end;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.cpf = cpf;
        this.nome_pet = nome_pet;
        this.apelido_pet = apelido_pet;
        this.nascimento_pet = nascimento_pet;
        this.peso_pet = peso_pet;
        this.raca_pet = raca_pet;
        this.porte_pet = porte_pet;
        this.senha = senha;
    }
    private int codigo;
    private String nome;
    private String endereco;
    private int numero_end;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String telefone;
    private String celular;
    private String email;
    private String cpf;
    private String nome_pet;
    private String apelido_pet;
    private String nascimento_pet;
    private String peso_pet;
    private String raca_pet;
    private String porte_pet;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(int numero_end) {
        this.numero_end = numero_end;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getApelido_pet() {
        return apelido_pet;
    }

    public void setApelido_pet(String apelido_pet) {
        this.apelido_pet = apelido_pet;
    }

    public String getNascimento_pet() {
        return nascimento_pet;
    }

    public void setNascimento_pet(String nascimento_pet) {
        this.nascimento_pet = nascimento_pet;
    }

    public String getPeso_pet() {
        return peso_pet;
    }

    public void setPeso_pet(String peso_pet) {
        this.peso_pet = peso_pet;
    }

    public String getRaca_pet() {
        return raca_pet;
    }

    public void setRaca_pet(String raca_pet) {
        this.raca_pet = raca_pet;
    }

    public String getPorte_pet() {
        return porte_pet;
    }

    public void setPorte_pet(String porte_pet) {
        this.porte_pet = porte_pet;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
