package br.senai.sc.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import br.senai.sc.eventos.database.EventoDAO;
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
        AutoCompleteTextView lista = (AutoCompleteTextView) findViewById(R.id.listView_NomeEventos);

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