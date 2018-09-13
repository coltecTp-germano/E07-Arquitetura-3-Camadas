package br.ufmg.coltec.tp.appacademico.model.builder;

import android.content.ContentValues;

import br.ufmg.coltec.tp.appacademico.model.Professor;

import static br.ufmg.coltec.tp.appacademico.data.contract.ProfessorContract.ProfessorEntry.COLUMN_ID;
import static br.ufmg.coltec.tp.appacademico.data.contract.ProfessorContract.ProfessorEntry.COLUMN_NAME;

public class ProfessorBuilder {
    public static Professor fromContentValues(ContentValues values) {
        final Professor professor = new Professor();

        if (values.containsKey(COLUMN_ID)) {
            professor.setId(values.getAsLong(COLUMN_ID));
        }

        if (values.containsKey(COLUMN_NAME)) {
            professor.setNome(values.getAsString(COLUMN_NAME));
        }

        return professor;
    }
}
