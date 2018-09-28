package br.ufmg.coltec.tp.appacademico.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract.AlunoEntry.COLUMN_ID;
import static br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract.AlunoEntry.COLUMN_MAT;
import static br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract.AlunoEntry.COLUMN_NAME;
import static br.ufmg.coltec.tp.appacademico.data.contract.AlunoContract.AlunoEntry.TABLE_NAME;

@Entity(tableName = TABLE_NAME,
        indices = {@Index
                (value = {COLUMN_MAT})
        })
public class Aluno {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    private long id;

    @ColumnInfo(name = COLUMN_NAME)
    private String nome;

    @ColumnInfo(name = COLUMN_MAT)
    private String matricula;

    public Aluno() {}

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public Aluno(long id, String nome, String matricula) {
        this(nome, matricula);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
