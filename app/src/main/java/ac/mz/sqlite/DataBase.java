package ac.mz.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class Database extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "ALUNOS";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String CURSO = "curso";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY, "
                    + NOME + " TEXT NOT NULL, " + CURSO + " TEXT);";

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long save(String nome, String curso) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(NOME, nome);
        valores.put(CURSO, curso);

        long insert = database.insert(TABLE_NAME, null, valores);

        database.close();

        return insert;
    }
}
