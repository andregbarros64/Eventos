package br.senai.sc.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.senai.sc.eventos.modelo.Participante;

public class CadastroEventoActivity extends AppCompatActivity {

    private  final int RESULT_CODE_NOVO_PARTICIPANTE = 10;
    private final int RESULT_CODE_PARTICIPANTE_EDITADO = 11;

    private boolean edicao = false;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);
        setTitle("Cadastro de participante");
        carregarParticipante();
    }

    private void carregarParticipante(){
        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null &&
                intent.getExtras().get("participanteEdicao") != null){
            Participante participante = (Participante) intent.getExtras().get("participanteEdicao");
            EditText editTextEvento = findViewById(R.id.editText_Evento);
            EditText editTextNome = findViewById(R.id.editTextNome);
            EditText editTextCPF = findViewById((R.id.editText_CPF));
            editTextEvento.setText(participante.getlocalEvento());
            editTextNome.setText(participante.getNome());
            editTextCPF.setText(participante.getIdentificao());
            id = participante.getId();
        }
    }

    public void  onClickVoltar(View v){
        finish();
    }

    public void onClickSalvar(View v) {
        EditText editTextEvento = findViewById(R.id.editText_Evento);
        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextCPF = findViewById(R.id.editText_CPF);

        String evento = editTextEvento.getText().toString();
        String nome = editTextNome.getText().toString();
        String CPF = editTextCPF.getText().toString();

        Participante participante = new Participante(id, evento, nome, CPF);
        Intent intent = new Intent();

        if (edicao){
            intent.putExtra("participanteEditado",participante);
            setResult(RESULT_CODE_PARTICIPANTE_EDITADO, intent);
        } else{
            intent.putExtra("novoParticipante", participante);
            setResult(RESULT_CODE_NOVO_PARTICIPANTE, intent);
        }
        finish();
    }
}