package br.senai.sc.eventos.database.entity;

import android.provider.BaseColumns;

public final class EventoEntity implements BaseColumns{

    private EventoEntity(){};

    public static final String TABLE_NAME = "eventos";
    public static final String COLUMN_NAME_NOME = "evento";
    public static final String COLUMN_NAME_PARTICIPANTE = "participante";
    public static final String COLUMN_NAME_valor = "CPF";
}

