package br.ufmg.coltec.tp.appacademico.data.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import br.ufmg.coltec.tp.appacademico.model.Professor;

import static br.ufmg.coltec.tp.appacademico.data.contract.ProfessorContract.ProfessorEntry.COLUMN_ID;
import static br.ufmg.coltec.tp.appacademico.data.contract.ProfessorContract.ProfessorEntry.TABLE_NAME;

@Dao
public interface IProfessorRepository {
    @Insert
    void insert(Professor professor);

    @Update
    int update(Professor professor);

    @Query("DELETE FROM " + TABLE_NAME)
    int deleteAll();

    @Query("DELETE FROM " + TABLE_NAME + " WHERE " +  COLUMN_ID + " = :id")
    int deleteById(long id);

    @Query("SELECT COUNT(*) FROM " + TABLE_NAME)
    int count();

    @Query("SELECT * FROM " + TABLE_NAME)
    Cursor selectAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = :id")
    Cursor selectById(long id);
}
