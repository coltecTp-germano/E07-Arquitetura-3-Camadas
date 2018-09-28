package br.ufmg.coltec.tp.appacademico.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.ufmg.coltec.tp.appacademico.R;
import br.ufmg.coltec.tp.appacademico.view.Aluno.AlunoActivity;
import br.ufmg.coltec.tp.appacademico.view.Professor.ProfessorActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aluno     = findViewById(R.id.btn_aluno);
        Button professor = findViewById(R.id.btn_professor);

        aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alunoActivity = new Intent(MainActivity.this, AlunoActivity.class);
                startActivity(alunoActivity);
            }
        });

        professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent professorActivity = new Intent(MainActivity.this, ProfessorActivity.class);
                startActivity(professorActivity);
            }
        });

    }
}
