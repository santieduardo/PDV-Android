package eduardosanti.com.br.pdv.dao.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import eduardosanti.com.br.pdv.dao.UserDAO;
import eduardosanti.com.br.pdv.model.User;

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

        Cursor cursor = db.query("user",  new String[]{"id", "email", "password"},
                "email = ?",new String[]{"admin@admin.com"},
                null,null,null);

        if(!cursor.moveToNext()){
            db.execSQL("INSERT INTO user (email, password) VALUES ('admin@admin.com', 'admin')");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE user");
        db.execSQL(createTable);
    }
}