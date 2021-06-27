package br.senai.sc.eventos.database.contract;

import br.senai.sc.eventos.database.entity.EventoEntity;
import br.senai.sc.eventos.database.entity.EventoNomeEntity;

public class EventoNomeContract {

    private EventoNomeContract(){};

    public static final String criarTabela(){
        return "CREATE_TABLE " + EventoNomeEntity.TABLE_NAME + " (" +
                EventoNomeEntity.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, " +
                EventoNomeEntity.COLUMN_NAME_EVENTO + "TEXT";
    }

    public final static String removerTabela(){
        return "DROP TABLE IF EXISTS " + EventoNomeEntity.TABLE_NAME;
    }
}
