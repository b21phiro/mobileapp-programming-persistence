package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class activity_read extends AppCompatActivity {

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        // Create
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        List<User> users = getUsers();

        TextView list = findViewById(R.id.dataList);

        for(int i = 0; i < users.size(); i++) {
            String data = users.get(i).toString();
            String text = list.getText().toString();
            text += data+"\n";
            list.setText(text);
        }

    }

    private List<User> getUsers() {
        Cursor cursor = database.query(DatabaseTables.User.TABLE_NAME, null, null, null, null, null, null);
        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            User user = new User(
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.User.COLUMN_NAME_USERNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.User.COLUMN_NAME_EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.User.COLUMN_NAME_PASSWORD))
            );
            users.add(user);
        }
        cursor.close();
        return users;
    }

}