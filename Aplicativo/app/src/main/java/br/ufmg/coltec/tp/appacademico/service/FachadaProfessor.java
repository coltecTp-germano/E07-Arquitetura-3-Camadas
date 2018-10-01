package br.ufmg.coltec.tp.appacademico.service;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.controller.ProfessorController;
import br.ufmg.coltec.tp.appacademico.model.Professor;
import br.ufmg.coltec.tp.appacademico.service.interfaces.IFachadaProfessor;

public class FachadaProfessor implements IFachadaProfessor {

    private ProfessorController mProfessorController;

    public FachadaProfessor (ProfessorController professorController) {
        mProfessorController = professorController;
    }

    @Override
    public void addProfessor(Professor professor) {
        mProfessorController.addProfessor(professor);
    }

    @Override
    public void updateProfessor(Professor professor) {
        mProfessorController.updateProfessor(professor);
    }

    @Override
    public List<Professor> selectAll() {
        return mProfessorController.selectAll();
    }

    @Override
    public void deleteProfessor(String name) {
        mProfessorController.deleteAluno(name);
    }
}
