package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;

import br.ufmg.coltec.tp.appacademico.controller.ProfessorController;
import br.ufmg.coltec.tp.appacademico.data.Database;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IProfessorRepository;

import br.ufmg.coltec.tp.appacademico.service.FachadaProfessor;
import dagger.Module;
import dagger.Provides;

@Module
public class ProfessorModule {

    @Provides
    public IProfessorRepository providesProfessorRepository(Database db) {
        return db.getProfessorRepository();
    }

    @Provides
    public ProfessorController provideProfessorController(IProfessorRepository repository) {
        return new ProfessorController(repository);
    }

    @Provides
    public FachadaProfessor provideFachadaProfessor(ProfessorController controller) {
        return new FachadaProfessor(controller);
    }

}
