package br.ufmg.coltec.tp.appacademico.view.Aluno;

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
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.MainApplication;
import br.ufmg.coltec.tp.appacademico.model.Aluno;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaAluno;
import br.ufmg.coltec.tp.appacademico.view.SearchModel;
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class AlunoActivity extends Activity {

    @Inject
    public IFachadaAluno fachadaAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        Button add     = findViewById(R.id.add_aluno);
        Button search  = findViewById(R.id.del_aluno);

        MainApplication.getComponent().inject(this); // informando ao dagger sobre o uso de um component e a necessidade de injetar dependência

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
                            fachadaAluno.addAluno(new Aluno(nome.toString(), matricula.toString()));
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



        // Search aluno
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SimpleSearchDialogCompat(AlunoActivity.this,
                    "Deletar um aluno",
                    "Nome...",
                    null,
                    initData(),
                    new SearchResultListener<Searchable>() {
                        @Override
                        public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                            Toast.makeText(AlunoActivity.this,
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
        items.add(new SearchModel("Bryan"));
        items.add(new SearchModel("Germano"));
        items.add(new SearchModel("Bernardo"));
        items.add(new SearchModel("Mariana"));
        items.add(new SearchModel("Gustavo"));
        items.add(new SearchModel("Rita"));

        return items;
    }
}
