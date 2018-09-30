package br.ufmg.coltec.tp.appacademico.controller;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.coltec.tp.appacademico.data.contract.ProfessorContract;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IProfessorRepository;
import br.ufmg.coltec.tp.appacademico.model.Professor;

public class ProfessorController {

    private List<Professor> mProfessors;
    private IProfessorRepository mProfessorRepository;

    public ProfessorController(IProfessorRepository professorRepository) {
        mProfessorRepository = professorRepository;
        mProfessors = new ArrayList<Professor>();
    }

    public void addProfessor(Professor professor) {
        mProfessorRepository.insert(professor);
    }

    public void updateProfessor(Professor professor) {
        mProfessorRepository.update(professor);
    }

    public List<Professor> selectAll() {
        Cursor c = mProfessorRepository.selectAll();
        mProfessors.clear();

        if(c.moveToFirst()){
            do{
                mProfessors.add(createProfessorFromCursor(c));
            }while(c.moveToNext());
        }

        return mProfessors;
    }

    public void deleteAluno(String nome) {
        mProfessorRepository.deleteByName(nome);
    }

    private Professor createProfessorFromCursor(Cursor c) {
        if (c == null)
            return null;

        Professor professor = new Professor();

        professor.setId(c.getLong(c.getColumnIndexOrThrow(ProfessorContract.ProfessorEntry.COLUMN_ID)));
        professor.setNome(c.getString(c.getColumnIndexOrThrow(ProfessorContract.ProfessorEntry.COLUMN_NAME)));

        return professor;
    }
}
