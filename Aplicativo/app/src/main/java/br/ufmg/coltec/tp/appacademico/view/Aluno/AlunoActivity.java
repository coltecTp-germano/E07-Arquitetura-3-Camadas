package br.ufmg.coltec.tp.appacademico.view.Aluno;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.ufmg.coltec.tp.appacademico.R;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.AlunoModule;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.AppModule;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.DaggerAppComponent;
import br.ufmg.coltec.tp.appacademico.crossCutting.IoC.RoomModule;
import br.ufmg.coltec.tp.appacademico.model.Aluno;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaAluno;
import br.ufmg.coltec.tp.appacademico.view.SearchModel;
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

import static android.content.ContentValues.TAG;

public class AlunoActivity extends Activity {

    @Inject
    public IFachadaAluno fachadaAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        Button add     = findViewById(R.id.add_aluno);
        Button search  = findViewById(R.id.del_aluno);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .alunoModule(new AlunoModule())
                .build()
                .inject(this);

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

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!nome.getText().toString().isEmpty() && !matricula.getText().toString().isEmpty()) {
                            fachadaAluno.addAluno(new Aluno(nome.getText().toString(), matricula.getText().toString()));
                            Toast.makeText(AlunoActivity.this,
                                    nome.getText().toString() + " adicionado",
                                    Toast.LENGTH_SHORT)
                                    .show();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(AlunoActivity.this,
                                    "Preencha todos os campos",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
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
                            String name = searchable.getTitle();
                            Toast.makeText(AlunoActivity.this,
                                    name +" deletado",
                                    Toast.LENGTH_SHORT)
                                    .show();
                            fachadaAluno.deleteAluno(name);
                            baseSearchDialogCompat.dismiss();
                        }
                    }).show();
            }
        });
    }

    private ArrayList<SearchModel> initData() {
        ArrayList<SearchModel> items = new ArrayList<>();

        List<Aluno> alunos = fachadaAluno.selectAll();

        for(int i = 0; i < alunos.size(); i++) {
            items.add(new SearchModel(alunos.get(i).getNome()));
        }

        return items;
    }
}
