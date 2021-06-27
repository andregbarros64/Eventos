package br.senai.sc.eventos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.senai.sc.eventos.database.entity.EventoEntity;
import br.senai.sc.eventos.modelo.Participante;

public class EventoDAO {

    private final String SQL_LISTAR_TODOS = "SELECT * FROM " + EventoEntity.TABLE_NAME;

    private static DBGateway dbGateway;

    public  EventoDAO(Context context){
        dbGateway = DBGateway.getInstance(context);
    }

    public static boolean salvar(Participante participante){
        ContentValues contentValues = new ContentValues();
        contentValues.put(EventoEntity.COLUMN_NAME_NOME, participante.getlocalEvento());
        contentValues.put(EventoEntity.COLUMN_NAME_PARTICIPANTE,participante.getNome());
        contentValues.put(EventoEntity.COLUMN_NAME_valor,participante.getIdentificao());
        if (participante.getId() > 0) {
            return dbGateway.getDataBase().update(EventoEntity.TABLE_NAME,
                    contentValues,
                    EventoEntity._ID + "=?",
                    new String[]{String.valueOf(participante.getId())}) > 0;
        }
        return dbGateway.getDataBase().insert(EventoEntity.TABLE_NAME,
                null, contentValues)  > 0;
    }

    public static boolean excluir(Participante participante) {
        if (participante.getId() > 0) {
            return dbGateway.getDataBase().delete(EventoEntity.TABLE_NAME,
                    EventoEntity._ID + "=?",
                    new String[]{String.valueOf(participante.getId())}) > 0;
        }
        return false;
    }


    public List<Participante> listar(){
        List<Participante> participantes = new ArrayList<>();
        Cursor cursor = dbGateway.getDataBase().rawQuery(SQL_LISTAR_TODOS,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(EventoEntity._ID));
            String nome = cursor.getString(cursor.getColumnIndex(EventoEntity.COLUMN_NAME_NOME));
            String participante = cursor.getString(cursor.getColumnIndex(EventoEntity.COLUMN_NAME_PARTICIPANTE));
            String identificacao = cursor.getString(cursor.getColumnIndex(EventoEntity.COLUMN_NAME_valor));
            participantes.add(new Participante(id,nome,participante,identificacao));
        }
        cursor.close();
        return participantes;
    }

    public static DBGateway getDbGateway() {
        return dbGateway;
    }
}
