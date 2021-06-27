package br.senai.sc.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
=======
import android.widget.ArrayAdapter;
>>>>>>> a59515a9dbcb290ca60b6036dbb5ae2a523493b3
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;

import br.senai.sc.eventos.database.EventoDAO;
import br.senai.sc.eventos.database.entity.EventoEntity;
import br.senai.sc.eventos.modelo.Participante;

public class CadastroEventoActivity extends AppCompatActivity {

    private boolean edicao = false;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);
        setTitle("Cadastro de participante");
        carregarParticipante();
<<<<<<< HEAD
        AutoCompleteTextView lista = (AutoCompleteTextView) findViewById(R.id.listView_NomeEventos);
=======

        AutoCompleteTextView editText = findViewById(R.id.editText_EventoLista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Collections.singletonList("select distinct " + EventoEntity.COLUMN_NAME_NOME
                + "from " + EventoEntity.TABLE_NAME + " where " + EventoEntity.COLUMN_NAME_NOME + " LIKE %" + editText.toString() + "% order by 1 asc"));
        editText.setAdapter(adapter);
>>>>>>> a59515a9dbcb290ca60b6036dbb5ae2a523493b3

    }

    private void carregarParticipante(){
        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null &&
                intent.getExtras().get("participanteEdicao") != null){
            Participante participante = (Participante) intent.getExtras().get("participanteEdicao");
            EditText editTextEvento = findViewById(R.id.editText_EventoLista);
            EditText editTextNome = findViewById(R.id.editTextNome);
            EditText editTextCPF = findViewById((R.id.editText_CPF));
            editTextEvento.setText(participante.getlocalEvento());
            editTextNome.setText(participante.getNome());
            editTextCPF.setText(participante.getIdentificao());
            id = participante.getId();
        }
    }

    public void  onClickVoltar(View v){

        EditText editTextEvento = findViewById(R.id.editText_EventoLista);
        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextCPF = findViewById(R.id.editText_CPF);

        String evento = editTextEvento.getText().toString();
        String nome = editTextNome.getText().toString();
        String CPF = editTextCPF.getText().toString();

        Participante participante = new Participante(id, evento, nome, CPF);
        EventoDAO produtoDAO = new EventoDAO(getBaseContext());
        boolean salvou = EventoDAO.salvar(participante);
        if(salvou){
            finish();
        } else{
            Toast.makeText(CadastroEventoActivity.this,"Erro ao salvar", Toast.LENGTH_LONG).show();
        }
    }

    public void  onClickExcluir(View v){
        Participante participante = new Participante(id, null, null, null);
        EventoDAO produtoDAO = new EventoDAO(getBaseContext());
        boolean excluiu = EventoDAO.excluir(participante);
        if(excluiu){
            finish();
        } else{
            Toast.makeText(CadastroEventoActivity.this,"Erro ao exluir", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickSalvar(View v) {
        EditText editTextEvento = findViewById(R.id.editText_EventoLista);
        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextCPF = findViewById(R.id.editText_CPF);

        String evento = editTextEvento.getText().toString();
        String nome = editTextNome.getText().toString();
        String CPF = editTextCPF.getText().toString();

        Participante participante = new Participante(id, evento, nome, CPF);
        EventoDAO produtoDAO = new EventoDAO(getBaseContext());
        boolean salvou = EventoDAO.salvar(participante);
        if(salvou){
             finish();
         } else{
         Toast.makeText(CadastroEventoActivity.this,"Erro ao salvar", Toast.LENGTH_LONG).show();
        }
    }
}