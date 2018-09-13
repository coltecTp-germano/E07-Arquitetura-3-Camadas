package br.ufmg.coltec.tp.appacademico.model.builder;

import android.content.ContentValues;

import br.ufmg.coltec.tp.appacademico.model.Aluno;

import static br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract.AlunoEntry.COLUMN_ID;
import static br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract.AlunoEntry.COLUMN_MAT;
import static br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract.AlunoEntry.COLUMN_NAME;

public class AlunoBuilder {
    public static Aluno fromContentValues(ContentValues values) {
        final Aluno aluno = new Aluno();

        if (values.containsKey(COLUMN_ID)) {
            aluno.setId(values.getAsLong(COLUMN_ID));
        }

        if (values.containsKey(COLUMN_MAT)) {
            aluno.setMatricula(values.getAsString(COLUMN_MAT));
        }

        if (values.containsKey(COLUMN_NAME)) {
            aluno.setNome(values.getAsString(COLUMN_NAME));
        }

        return aluno;
    }

}
