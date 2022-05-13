package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button writeBtn, readBtn;
    private EditText username, email, password;
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        writeBtn = findViewById(R.id.write);
        readBtn = findViewById(R.id.read);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        // Triggers sending input data to SQL-database
        writeBtn.setOnClickListener(view -> {
            addUser(
                    username.getText().toString(),
                    email.getText().toString(),
                    password.getText().toString()
            );
        });

        // Triggers read from SQL-database
        readBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, activity_read.class);
            startActivity(intent);
        });

    }

    private long addUser(String username, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.User.COLUMN_NAME_USERNAME, username);
        values.put(DatabaseTables.User.COLUMN_NAME_EMAIL, email);
        values.put(DatabaseTables.User.COLUMN_NAME_PASSWORD, password);
        return database.insert(DatabaseTables.User.TABLE_NAME, null, values);
    }
}
