package br.ufmg.coltec.tp.appacademico.service;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.controller.AlunoController;
import br.ufmg.coltec.tp.appacademico.model.Aluno;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaAluno;

public class FachadaAluno implements IFachadaAluno {

    private AlunoController mAlunoController;

    public FachadaAluno (AlunoController alunoController) {
        mAlunoController = alunoController;
    }

    @Override
    public void addAluno(Aluno aluno) {
        mAlunoController.addAluno(aluno);
    }

    @Override
    public void updateAluno(Aluno aluno) {
        mAlunoController.updateAluno(aluno);
    }

    @Override
    public List<Aluno> selectAll() {
        return mAlunoController.selectAll();
    }

    @Override
    public void deleteAluno(long id) {
        mAlunoController.deleteAluno(id);
    }
}
