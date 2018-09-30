package br.ufmg.coltec.tp.appacademico.service.interfaces;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.model.Professor;

public interface IFachadaProfessor {
    public void addProfessor(Professor professor);
    public void updateProfessor(Professor professor);
    public List<Professor> selectAll();
    public void deleteProfessor(long id);
}
