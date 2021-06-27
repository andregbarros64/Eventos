package br.senai.sc.eventos.modelo;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class NomeEvento implements Serializable {
    private int id;
    private String nome;

    public NomeEvento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public NomeEvento(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
