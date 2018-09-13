package br.ufmg.coltec.tp.appacademico.data;

import android.arch.persistence.room.RoomDatabase;

import br.ufmg.coltec.tp.appacademico.model.Aluno;
import br.ufmg.coltec.tp.appacademico.model.Professor;

@android.arch.persistence.room.Database(entities = {Aluno.class, Professor.class}, version = 1)
public abstract class Database extends RoomDatabase {

}
