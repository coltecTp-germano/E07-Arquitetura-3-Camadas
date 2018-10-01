package br.ufmg.coltec.tp.appacademico.view.Professor;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.ufmg.coltec.tp.appacademico.R;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.AppModule;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.DaggerAppComponent;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.ProfessorModule;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.RoomModule;
import br.ufmg.coltec.tp.appacademico.model.Professor;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaProfessor;
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

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .professorModule(new ProfessorModule())
                .build()
                .inject(this);

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

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!nome.getText().toString().isEmpty()) {

                            /* add professor */
                            fachadaProfessor.addProfessor(new Professor(nome.getText().toString()));

                            Toast.makeText(ProfessorActivity.this,
                                    nome.getText().toString() + " adicionado",
                                    Toast.LENGTH_SHORT)
                                    .show();
                            dialog.dismiss();

                        } else {
                            Toast.makeText(ProfessorActivity.this,
                                    "Preencha todos os campos",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
            }
        });


        // Search professor and delete
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
                                String name = searchable.getTitle();
                                Toast.makeText(ProfessorActivity.this,
                                        name + " deletado",
                                        Toast.LENGTH_SHORT)
                                        .show();
                                fachadaProfessor.deleteProfessor(name);
                                baseSearchDialogCompat.dismiss();
                            }
                        }).show();
            }
        });
    }

    private ArrayList<SearchModel> initData() {
        ArrayList<SearchModel> items = new ArrayList<>();

        List<Professor> professores = fachadaProfessor.selectAll();

        for (int i = 0; i < professores.size(); i++)
            items.add(new SearchModel(professores.get(i).getNome()));

        return items;
    }

}
