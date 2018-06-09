package eduardosanti.com.br.pdv.dao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseOpenHelper extends SQLiteOpenHelper {
    private static String databaseName = "pdv.db";

    private static String createTable = "CREATE TABLE user" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "email VARCHAR(80)," +
            "password VARCHAR(80))";

    public DataBaseOpenHelper(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE user");
        db.execSQL(createTable);
    }
}