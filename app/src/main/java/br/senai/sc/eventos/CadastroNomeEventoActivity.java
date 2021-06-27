package br.senai.sc.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import br.senai.sc.eventos.database.EventoNomeDAO;
import br.senai.sc.eventos.modelo.NomeEvento;

public class CadastroNomeEventoActivity  extends AppCompatActivity{

    private boolean edicao = false;
    private int id = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_nome_evento);
        setTitle("Cadastro de Evento");
        carregarEventos();
    }

    private void carregarEventos(){
        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null &&
                intent.getExtras().get("eventoEdicao") != null){
            NomeEvento nome = (NomeEvento) intent.getExtras().get("eventoEdicao");
            EditText editTextEvento = findViewById(R.id.editText_EventoLista);

            editTextEvento.setText(nome.getNome());
            id = nome.getId();
        }
    }
}
