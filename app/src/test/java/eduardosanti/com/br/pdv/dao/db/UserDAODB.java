package eduardosanti.com.br.pdv.dao.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import eduardosanti.com.br.pdv.dao.UserDAO;
import eduardosanti.com.br.pdv.model.User;

public class UserDAODB implements UserDAO {
    private DataBaseOpenHelper dataBaseOpenHelper;

    public UserDAODB(Context context) {
        this.dataBaseOpenHelper = new DataBaseOpenHelper(context);
    }

    @Override
    public void create(User user) {
        SQLiteDatabase dataBase = dataBaseOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        dataBase.insert("user", null, values);
        dataBase.close();
    }

    @Override
    public void delete(User user) {
        SQLiteDatabase dataBase = dataBaseOpenHelper.getWritableDatabase();

        dataBase.delete("user", "id=?", new String[]{String.valueOf(user.getId())});
        dataBase.close();
    }

    @Override
    public void update(User user) {
        SQLiteDatabase dataBase = dataBaseOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        dataBase.update("user", values,"id=?", new String[]{String.valueOf(user.getId())});
        dataBase.close();
    }

    @Override
    public ArrayList<User> findAll() {
        SQLiteDatabase dataBase = dataBaseOpenHelper.getReadableDatabase();

        Cursor cursor = dataBase.query("user", new String[]{"id", "email", "password"},
                null,null,null,null,"email");

        ArrayList<User> users = new ArrayList<>();

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            User user = new User(id, email, password);
            users.add(user);
        }

        return users;
    }

    @Override
    public User findById(int id) {
        SQLiteDatabase dataBase = dataBaseOpenHelper.getReadableDatabase();

        Cursor cursor = dataBase.query("user",  new String[]{"id", "email", "password"},
                "id = ?",new String[]{String.valueOf(id)},
                null,null,null);

        if(cursor.moveToNext()){
            int userId = cursor.getInt(cursor.getColumnIndex("id"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            User user = new User(userId, email, password);
            return user;
        }

        return null;
    }

    @Override
    public User findByEmail(String value) {
        SQLiteDatabase dataBase = dataBaseOpenHelper.getReadableDatabase();

        Cursor cursor = dataBase.query("user",  new String[]{"id", "email", "password"},
                "email = ?",new String[]{value},
                null,null,null);

        if(cursor.moveToNext()){
            int userId = cursor.getInt(cursor.getColumnIndex("id"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            User user = new User(userId, email, password);
            return user;
        }

        return null;
    }
}

