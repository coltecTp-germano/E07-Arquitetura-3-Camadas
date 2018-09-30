package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;

import android.app.Application;

import javax.inject.Singleton;

import br.ufmg.coltec.tp.appacademico.controller.AlunoController;
import br.ufmg.coltec.tp.appacademico.controller.ProfessorController;
import br.ufmg.coltec.tp.appacademico.data.Database;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IAlunoRepository;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IProfessorRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private Database database;

    public RoomModule(Application mApplication) {
        database = Database.getInstance(mApplication.getApplicationContext());
//        database = Room.databaseBuilder(mApplication, Database.class, "demo-db").build();
    }

    @Singleton
    @Provides
    Database providesRoomDatabase() {
        return database;
    }

    @Singleton
    @Provides
    IAlunoRepository providesAlunoRepository(Database database) {
        return database.iAlunoRepository();
    }

    @Provides
    public AlunoController provideAlunoController(IAlunoRepository repository) {
        return new AlunoController(repository);
    }

    @Singleton
    @Provides
    IProfessorRepository providesProfessorRepository(Database database) {
        return database.iProfessorRepository();
    }

    @Singleton
    @Provides
    public ProfessorController provideProfessorController(IProfessorRepository repository) {
        return new ProfessorController(repository);
    }
}
