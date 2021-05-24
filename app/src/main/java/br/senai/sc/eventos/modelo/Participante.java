package br.senai.sc.eventos.modelo;

import android.icu.text.CaseMap;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Participante implements Serializable {
    private int id;
    private String localEvento;
    private String nome;
    private String identificao;

    public Participante(int id, String evento, String nome, String identificao) {
        this.id = id;
        this.localEvento = evento;
        this.nome = nome;
        this.identificao = identificao;
    }

    public Participante(String evento, String nome, String identificao) {
        this.localEvento = evento;
        this.nome = nome;
        this.identificao = identificao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificao() {
        return identificao;
    }

    public void setIdentificao(String identificao) {
        this.identificao = identificao;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " - CPF: " + identificao;
    }
}
