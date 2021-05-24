package br.senai.sc.eventos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.senai.sc.eventos.modelo.Participante;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE_NOVOPARTICIPANTE = 1;
    private final int RESULT_CODE_NOVOPARTICIPANTE = 10;
    private final int REQUEST_CODE_EDITARPRODUTO = 2;
    private final int RESULT_CODE_PARTICIPANTE_EDITADO = 11;

    private ListView listViewParticipantes;
    private ArrayAdapter<Participante> adapterParticipantes;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Eventos");

        listViewParticipantes = findViewById(R.id.listView_Participantes);
        ArrayList<Participante> participante = new ArrayList<Participante>();

        adapterParticipantes = new ArrayAdapter<Participante>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,
                participante);
        listViewParticipantes.setAdapter(adapterParticipantes);
        definirOnclickListenerListview();
    }

    private void definirOnclickListenerListview(){
        listViewParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Participante participanteClicado =  adapterParticipantes.getItem(position);
            Intent intent = new Intent(MainActivity.this, CadastroEventoActivity.class);
            intent.putExtra("participanteEdicao",participanteClicado);
            startActivityForResult(intent,REQUEST_CODE_EDITARPRODUTO);
            }
        });
    }

    public void onClickNovoParticipante(View v){
        Intent intent = new Intent(MainActivity.this, CadastroEventoActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NOVOPARTICIPANTE);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){

        if(requestCode == REQUEST_CODE_NOVOPARTICIPANTE && resultCode == RESULT_CODE_NOVOPARTICIPANTE){
            Participante participante = (Participante) data.getExtras().getSerializable("novoParticipante");
            participante.setId(++id);
            this.adapterParticipantes.add(participante);
        } else if(requestCode == REQUEST_CODE_EDITARPRODUTO && resultCode == RESULT_CODE_PARTICIPANTE_EDITADO){
            Participante participanteEditado = (Participante) data.getExtras().getSerializable("participanteEditado");
            for (int i = 0; i < adapterParticipantes.getCount(); i++){
                Participante participante = adapterParticipantes.getItem(i);
                if(participante.getId() == participanteEditado.getId()){
                    adapterParticipantes.remove(participante);
                    adapterParticipantes.insert(participanteEditado, i);
                    break;
                }
            };
        }
        super.onActivityResult(requestCode,resultCode,data);

    }
}