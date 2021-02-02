package com.example.demo.BACK;

import com.example.demo.MODEL.Record1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.beans.BeanProperty;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCClass {
    public JDBCClass() {

    }





    private final String DATABASE_URL = "jdbc:postgresql://10.10.10.142:5432/backtosch";


    static final String JDBC_DRIVER = "org.postgresql.Driver";



    static String  USER = "inozemcevns";


    static String PASSWORD = "Tjed_913";

    private Connection connection = null;


    public void createConnection() {
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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
    public void deleteConnection() {
        if(connection != null) {
            try {
                connection.close();
                System.out.println("ok");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
