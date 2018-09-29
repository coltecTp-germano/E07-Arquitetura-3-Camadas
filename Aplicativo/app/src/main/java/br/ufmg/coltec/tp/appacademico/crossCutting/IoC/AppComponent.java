package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;


import android.app.Application;

import javax.inject.Singleton;

import br.ufmg.coltec.tp.appacademico.controller.AlunoController;
import br.ufmg.coltec.tp.appacademico.controller.ProfessorController;
import br.ufmg.coltec.tp.appacademico.data.Database;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IAlunoRepository;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IProfessorRepository;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaAluno;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaProfessor;
import br.ufmg.coltec.tp.appacademico.view.Aluno.AlunoActivity;
import br.ufmg.coltec.tp.appacademico.view.Professor.ProfessorActivity;
import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class, ProfessorModule.class, AlunoModule.class})
public interface AppComponent {
    void inject(AlunoActivity alunoActivity);
    void inject(ProfessorActivity professorActivity);

    Database database();
    Application application();
    IAlunoRepository alunoRepository();
    IProfessorRepository professorRepository();
    AlunoController alunoController();
    ProfessorController professorController();
    IFachadaProfessor fachadaProfessor();
    IFachadaAluno fachadaAluno();
}
