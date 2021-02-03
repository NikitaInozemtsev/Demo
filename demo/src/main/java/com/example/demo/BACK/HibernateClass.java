package com.example.demo.BACK;

import com.example.demo.MODEL.Record1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HibernateClass implements Strategy {

    private String DATABASE_URL;
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    private String  USER;
    private String PASSWORD;

    public HibernateClass(String DATABASE_URL, String USER, String PASSWORD) {
        this.DATABASE_URL = DATABASE_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public void createConnection() {

    }

    @Override
    public ResponseEntity<List<Record1>> select() {
        return null;
    }

    @Override
    public void insert(String name, String data) {


    }
    @Override
    public void deleteConnection() {

    }
}
