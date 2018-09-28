package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;

import br.ufmg.coltec.tp.appacademico.controller.ProfessorController;
import br.ufmg.coltec.tp.appacademico.service.FachadaProfessor;
import dagger.Module;
import dagger.Provides;

@Module
public class ProfessorModule {

    @Provides
    public FachadaProfessor provideFachadaProfessor(ProfessorController controller) {
        return new FachadaProfessor(controller);
    }

}
