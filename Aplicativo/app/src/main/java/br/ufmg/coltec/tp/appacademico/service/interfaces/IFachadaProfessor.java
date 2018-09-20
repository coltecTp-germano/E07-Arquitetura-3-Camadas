package br.ufmg.coltec.tp.appacademico.service.interfaces;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.model.Professor;

public interface IFachadaProfessor {
    public void addAluno(Professor professor);
    public void updateAluno(Professor professor);
    public List<Professor> selectAll();
    public void deleteAluno(long id);
}
