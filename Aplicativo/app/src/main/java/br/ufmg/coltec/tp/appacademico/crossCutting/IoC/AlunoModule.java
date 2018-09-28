package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;

import br.ufmg.coltec.tp.appacademico.controller.AlunoController;
import br.ufmg.coltec.tp.appacademico.service.FachadaAluno;
import dagger.Module;
import dagger.Provides;

@Module
public class AlunoModule {

    @Provides
    public FachadaAluno provideFachadaAluno(AlunoController controller) {
        return new FachadaAluno(controller);
    }

}

