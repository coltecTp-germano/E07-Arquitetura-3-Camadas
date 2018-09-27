package br.ufmg.coltec.tp.appacademico.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufmg.coltec.tp.appacademico.controller.*;
import br.ufmg.coltec.tp.appacademico.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botões de aluno
        Button addAluno    = (Button) findViewById(R.id.btn_add_aluno);
        Button searchAluno = (Button) findViewById(R.id.btn_search_aluno);

        // Botões de professor
        Button addProfessor     = (Button) findViewById(R.id.btn_add_professor);
        Button searchProfessor  = (Button) findViewById(R.id.btn_search_professor);


        addAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.add_dialog,null);

                final EditText nome = (EditText) mView.findViewById(R.id.nome);
                final EditText matricula = (EditText) mView.findViewById(R.id.matricula);
                Button btn = (Button) mView.findViewById(R.id.concluir);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!nome.getText().toString().isEmpty() && !matricula.getText().toString().isEmpty()) {
                            // add aluno
                            Toast.makeText(MainActivity.this,
                                    "Adicionado com sucesso",
                                    Toast.LENGTH_SHORT);
                        }
                    }
                });

                mBuilder.setView(mView);
            }
        });

        searchAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        addProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        searchProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
