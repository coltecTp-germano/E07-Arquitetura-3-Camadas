package br.ufmg.coltec.tp.appacademico.data;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import br.ufmg.coltec.tp.appacademico.data.interfaces.IAlunoRepository;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IProfessorRepository;
import br.ufmg.coltec.tp.appacademico.model.Aluno;
import br.ufmg.coltec.tp.appacademico.model.Professor;

@android.arch.persistence.room.Database(entities = {Aluno.class, Professor.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract IAlunoRepository iAlunoRepository();
    public abstract IProfessorRepository iProfessorRepository();

    private static Database sInstance;

    public static synchronized Database getInstance (Context context) {
        if (sInstance == null) {
            sInstance = Room
                    .databaseBuilder(context.getApplicationContext(), Database.class, "Escola")
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    @VisibleForTesting
    public static void switchToInMemory(Context context) {
        sInstance = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                Database.class).build();
    }

//    public abstract IAlunoRepository getAlunoRepository();
//    public abstract IProfessorRepository getProfessorRepository();
}
