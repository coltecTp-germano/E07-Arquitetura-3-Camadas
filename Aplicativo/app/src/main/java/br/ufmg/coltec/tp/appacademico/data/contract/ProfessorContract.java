package br.ufmg.coltec.tp.appacademico.data.contract;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class ProfessorContract {
    public static final String CONTENT_AUTHORITY = "br.ufmg.coltec.tp.appacademico";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PROFESSOR = "professores";

    public ProfessorContract(){}

    public static class ProfessorEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PROFESSOR);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + PATH_PROFESSOR;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + PATH_PROFESSOR;

        public static final String TABLE_NAME = "professores";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "nome";
    }
}
