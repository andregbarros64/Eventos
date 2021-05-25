package br.senai.sc.eventos.database.contract;

import br.senai.sc.eventos.database.entity.EventoEntity;

public final class EventoContract {

    private EventoContract(){};

    public static final String criarTabela(){
        return "CREATE_TABLE " + EventoEntity.TABLE_NAME + " (" +
                EventoEntity._ID + " INTEGER PRIMARY KEY, " +
                EventoEntity.COLUMN_NAME_NOME + "TEXT, " +
                EventoEntity.COLUMN_NAME_PARTICIPANTE + "TEXT," +
                EventoEntity.COLUMN_NAME_valor + "TEXT";
    }

    public final static String removerTabela(){
        return "DROP TABLE IF EXISTS " + EventoEntity.TABLE_NAME;
    }

}
