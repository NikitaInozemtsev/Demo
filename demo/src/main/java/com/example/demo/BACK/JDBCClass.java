package com.example.demo.BACK;

import com.example.demo.MODEL.Record1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCClass implements Strategy {



    private String DATABASE_URL;
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    private String  USER;
    private String PASSWORD;

    public JDBCClass(String DATABASE_URL, String USER, String PASSWORD) {
        this.DATABASE_URL = DATABASE_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    private Connection connection = null;

    @Override
    public void createConnection() {
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ResponseEntity<List<Record1>> select() {
        Statement s = null;
        List<Record1> rd = new ArrayList<>();
        try {
            s = connection.createStatement();
            /*DatabaseMetaData md = connection.getMetaData();
            String tableName = md.getTables(null, null, "%",null).getString(3);*/
            ResultSet res = s.executeQuery("SELECT * FROM public.bruh");

            while (res.next()) {
                rd.add(new Record1(res.getInt(1), res.getString(2), res.getString(3)));
            }
            if(s != null) {
                s.close();
            }
            return new ResponseEntity<List<Record1>>(rd, HttpStatus.OK);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new ResponseEntity<List<Record1>>(rd, HttpStatus.OK);
    }

    @Override
    public void insert(String name, String data) {
        Statement s = null;
        try {
            s = connection.createStatement();
            String sql = "INSERT INTO public.bruh (name, data) " + "VALUES('" + name + "', '" + data + "')";
            s.executeUpdate(sql);
            if(s != null) {
                s.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    @Override
    public void deleteConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
