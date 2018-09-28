package br.ufmg.coltec.tp.appacademico.view.Aluno;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import br.ufmg.coltec.tp.appacademico.R;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IAlunoRepository;
import br.ufmg.coltec.tp.appacademico.model.Aluno;
import br.ufmg.coltec.tp.appacademico.service.FachadaAluno;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaAluno;

public class AlunoActivity extends Activity {

    @Inject
    public IAlunoRepository alunoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        Button add     = findViewById(R.id.add_aluno);
        Button del     = findViewById(R.id.del_aluno);
        Button search  = findViewById(R.id.search_aluno);


        // Add aluno
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AlunoActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.add_dialog,null);

                mBuilder.setTitle("Adicionar aluno");

                final EditText nome = mView.findViewById(R.id.nome);
                final EditText matricula = mView.findViewById(R.id.matricula);
                Button btn = mView.findViewById(R.id.concluir);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!nome.getText().toString().isEmpty() && !matricula.getText().toString().isEmpty()) {

                            Toast.makeText(AlunoActivity.this,
                                    "Adicionado com sucesso",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            Toast.makeText(AlunoActivity.this,
                                    "Preencha todos os campos",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });


        // Delete aluno
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        // Search aluno
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
