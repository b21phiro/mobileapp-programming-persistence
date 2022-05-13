package com.example.persistence;

public class DatabaseTables {

    static final String SQL_CREATE_TABLE_USER =
            "CREATE TABLE " + User.TABLE_NAME + " (" +
                    User.COLUMN_NAME_USERNAME + " STRING, " +
                    User.COLUMN_NAME_EMAIL + " STRING," +
                    User.COLUMN_NAME_PASSWORD + " STRING)";

    static final String SQL_DELETE_TABLE_USER =
            "DROP TABLE IF EXISTS " + User.TABLE_NAME;

    static class User {
        static final String
            TABLE_NAME = "user",
            COLUMN_NAME_USERNAME = "username",
            COLUMN_NAME_EMAIL = "email",
            COLUMN_NAME_PASSWORD = "password";
    }
}
