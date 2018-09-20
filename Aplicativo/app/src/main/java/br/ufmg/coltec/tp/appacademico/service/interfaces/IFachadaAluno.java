package br.ufmg.coltec.tp.appacademico.service.interfaces;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.model.Aluno;

public interface IFachadaAluno {
    public void addAluno(Aluno aluno);
    public void updateAluno(Aluno aluno);
    public List<Aluno> selectAll();
    public void deleteAluno(long id);
}
