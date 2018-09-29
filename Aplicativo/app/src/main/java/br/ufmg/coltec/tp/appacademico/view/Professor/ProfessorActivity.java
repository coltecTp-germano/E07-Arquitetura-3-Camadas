package br.ufmg.coltec.tp.appacademico.view.Professor;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import br.ufmg.coltec.tp.appacademico.R;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaProfessor;
import br.ufmg.coltec.tp.appacademico.view.Aluno.AlunoActivity;
import br.ufmg.coltec.tp.appacademico.view.SearchModel;
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class ProfessorActivity extends Activity {

    @Inject
    public IFachadaProfessor fachadaProfessor;

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


        // Search professor
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SimpleSearchDialogCompat(ProfessorActivity.this,
                        "Deletar um professor",
                        "Nome...",
                        null,
                        initData(),
                        new SearchResultListener<Searchable>() {
                            @Override
                            public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                                Toast.makeText(ProfessorActivity.this,
                                        searchable.getTitle()+" deletado",
                                        Toast.LENGTH_SHORT)
                                        .show();
                                baseSearchDialogCompat.dismiss();
                            }
                        }).show();
            }
        });
    }

    private ArrayList<SearchModel> initData() {
        ArrayList<SearchModel> items = new ArrayList<>();
        items.add(new SearchModel("João Montandon"));
        items.add(new SearchModel("Giovanni"));
        items.add(new SearchModel("Kelly"));
        items.add(new SearchModel("Natália"));
        items.add(new SearchModel("Tchelão"));
        items.add(new SearchModel("Eliezer"));

        return items;
    }

}
