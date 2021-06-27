package br.senai.sc.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;

import br.senai.sc.eventos.database.EventoDAO;
import br.senai.sc.eventos.database.EventoNomeDAO;
import br.senai.sc.eventos.modelo.NomeEvento;
import br.senai.sc.eventos.modelo.Participante;

public class MainActivity extends AppCompatActivity {
    private ListView listViewParticipantes;
    private ArrayAdapter<Participante> adapterParticipantes;
    private ArrayAdapter<NomeEvento> adapterEventos;
    private AutoCompleteTextView listViewEventos;
    private final int id = 0;
    private AutoCompleteTextView autoCompleteEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] locais = getResources().getStringArray(R.array.locais);
        setTitle("Eventos");
        listViewParticipantes = findViewById(R.id.listView_Participantes);
        ArrayList<Participante> participante = new ArrayList<Participante>();
        ArrayList<NomeEvento> eventos = new ArrayList<NomeEvento>();
        definirOnclickListenerListview();
  }

    @Override
    protected void onResume() {
        super.onResume();
        EventoDAO eventoDAO = new EventoDAO(getBaseContext());
        EventoNomeDAO eventoNomeDAO = new EventoNomeDAO(getBaseContext());

        adapterParticipantes = new ArrayAdapter<Participante>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                eventoDAO.listar());
        listViewParticipantes.setAdapter(adapterParticipantes);

        adapterEventos = new ArrayAdapter<NomeEvento>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                eventoNomeDAO.listar());
        listViewEventos.setAdapter(adapterEventos);


    }

    private void definirOnclickListenerListview(){
        listViewParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Participante participanteClicado =  adapterParticipantes.getItem(position);
            Intent intent = new Intent(MainActivity.this, CadastroEventoActivity.class);
            intent.putExtra("participanteEdicao",participanteClicado);
            startActivity(intent);
            }
        });
    }

    public void onClickNovoParticipante(View v){
        Intent intent = new Intent(MainActivity.this, CadastroEventoActivity.class);
        startActivity(intent);
    }
}


