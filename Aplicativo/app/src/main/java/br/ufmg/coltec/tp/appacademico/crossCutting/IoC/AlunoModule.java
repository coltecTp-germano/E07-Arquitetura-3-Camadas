package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;

import br.ufmg.coltec.tp.appacademico.controller.AlunoController;
import br.ufmg.coltec.tp.appacademico.service.FachadaAluno;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaAluno;
import dagger.Module;
import dagger.Provides;

@Module
public class AlunoModule {

    @Provides
    public IFachadaAluno provideFachadaAluno(AlunoController controller) {
        return new FachadaAluno(controller);
    }

}

