package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button writeBtn, readBtn;
    private EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeBtn = findViewById(R.id.write);
        readBtn = findViewById(R.id.read);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        // Triggers sending input data to SQL-database
        writeBtn.setOnClickListener(view -> {
            write(
                    username.getText().toString(),
                    email.getText().toString(),
                    password.getText().toString()
            );
        });

        // Triggers read from SQL-database
        readBtn.setOnClickListener(view -> {
            read();
        });

    }

    public void read() {

    }

    public void write(String username, String email, String password) {

    }

}
