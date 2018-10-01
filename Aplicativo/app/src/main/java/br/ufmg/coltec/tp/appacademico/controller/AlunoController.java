package br.ufmg.coltec.tp.appacademico.controller;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract;
import br.ufmg.coltec.tp.appacademico.data.interfaces.IAlunoRepository;
import br.ufmg.coltec.tp.appacademico.model.Aluno;

public class AlunoController {

    private List<Aluno> mAlunos;
    private IAlunoRepository mAlunoRepository;

    public AlunoController(IAlunoRepository alunoRepository) {
        mAlunos = new ArrayList<>();
        mAlunoRepository = alunoRepository;
    }

    public void addAluno(Aluno aluno) {
        mAlunoRepository.insert(aluno);
    }

    public void updateAluno(Aluno aluno) {
        mAlunoRepository.update(aluno);
    }

    public List<Aluno> selectAll() {
        Cursor c = mAlunoRepository.selectAll();
        mAlunos.clear();

        if(c.moveToFirst()){
            do{
                mAlunos.add(createAlunoFromCursor(c));
            }while(c.moveToNext());
        }

        return mAlunos;
    }

    public void deleteAluno(String name) {
        mAlunoRepository.deleteByName(name);
    }

    private Aluno createAlunoFromCursor(Cursor c) {
        if (c == null)
            return null;

        Aluno aluno = new Aluno();

        aluno.setId(c.getLong(c.getColumnIndexOrThrow(AlunoContract.AlunoEntry.COLUMN_ID)));
        aluno.setNome(c.getString(c.getColumnIndexOrThrow(AlunoContract.AlunoEntry.COLUMN_NAME)));
        aluno.setMatricula(c.getString(c.getColumnIndexOrThrow(AlunoContract.AlunoEntry.COLUMN_MAT)));

        return aluno;
    }
}
