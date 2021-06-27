package br.senai.sc.eventos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.senai.sc.eventos.database.entity.EventoNomeEntity;
import br.senai.sc.eventos.modelo.NomeEvento;

public class EventoNomeDAO {

    private final String SQL_LISTAR_TODOS = "SELECT * FROM " + EventoNomeEntity.TABLE_NAME;

    private static DBGateway dbGateway;

    public  EventoNomeDAO(Context context){
        dbGateway = DBGateway.getInstance(context);
    }

    public static boolean salvar(NomeEvento nomeEvento){
        ContentValues contentValues = new ContentValues();
        contentValues.put(EventoNomeEntity.COLUMN_NAME_EVENTO, nomeEvento.getNome());
        if (nomeEvento.getId() > 0) {
            return dbGateway.getDataBase().update(EventoNomeEntity.TABLE_NAME,
                    contentValues,
                    EventoNomeEntity.COLUMN_NAME_ID + "=?",
                    new String[]{String.valueOf(nomeEvento.getId())}) > 0;
        }
        return dbGateway.getDataBase().insert(EventoNomeEntity.TABLE_NAME,
                null, contentValues)  > 0;
    }

    public static boolean excluir(NomeEvento nomeEvento) {
        if (nomeEvento.getId() > 0) {
            return dbGateway.getDataBase().delete(EventoNomeEntity.TABLE_NAME,
                    EventoNomeEntity.COLUMN_NAME_ID + "=?",
                    new String[]{String.valueOf(nomeEvento.getId())}) > 0;
        }
        return false;
    }



    public List<NomeEvento> listar(){
        List<NomeEvento> nomes = new ArrayList<>();
        Cursor cursor = dbGateway.getDataBase().rawQuery(SQL_LISTAR_TODOS,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(EventoNomeEntity.COLUMN_NAME_ID));
            String nome = cursor.getString(cursor.getColumnIndex(EventoNomeEntity.COLUMN_NAME_EVENTO));
            nomes.add(new NomeEvento(id,nome));
        }
        cursor.close();
        return nomes;
    }
}
