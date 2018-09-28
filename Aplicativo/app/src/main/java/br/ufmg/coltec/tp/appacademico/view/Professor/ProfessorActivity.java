package br.ufmg.coltec.tp.appacademico.view.Professor;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufmg.coltec.tp.appacademico.R;

public class ProfessorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        Button add     = findViewById(R.id.add_prof);
        Button search  = findViewById(R.id.search_prof);


        // Add professor
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfessorActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.add_dialog,null);

                mBuilder.setTitle("Adicionar professor");

                final EditText nome = mView.findViewById(R.id.nome);

                // Remove o campo de matricula, já que professor não tem matricula (nao queria fazer outro layout.xml, sorry)
                mView.findViewById(R.id.matricula).setVisibility(View.GONE);

                Button btn = mView.findViewById(R.id.concluir);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!nome.getText().toString().isEmpty()) {

                            /* espaço pra função de add professor */

                            Toast.makeText(ProfessorActivity.this,
                                    "Adicionado com sucesso",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        } else {

                            Toast.makeText(ProfessorActivity.this,
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


        // Search aluno
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
