package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;

import br.ufmg.coltec.tp.appacademico.controller.AlunoController;
import br.ufmg.coltec.tp.appacademico.data.Database;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IAlunoRepository;
import br.ufmg.coltec.tp.appacademico.service.FachadaAluno;

import dagger.Module;
import dagger.Provides;

@Module
public class AlunoModule {

    @Provides
    public IAlunoRepository providesAlunoRepository(Database db) {
        return db.getAlunoRepository();
    }

    @Provides
    public AlunoController provideAlunoController(IAlunoRepository repository) {
        return new AlunoController(repository);
    }

    @Provides
    public FachadaAluno provideFachadaAluno(AlunoController controller) {
        return new FachadaAluno(controller);
    }

}

