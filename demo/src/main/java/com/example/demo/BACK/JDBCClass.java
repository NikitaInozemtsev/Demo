package com.example.demo.BACK;

import org.json.JSONObject;

import java.sql.*;

public class JDBCClass {

    static final String DATABASE_URL = "jdbc:mysql://localhost/PROSELYTE_JDBC_DB";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String USER = "ВАШЕ_ИМЯ_ПОЛЬЗОВАТЕЛЯ";
    static final String PASSWORD = "ВАШ_ПАРОЛЬ";

    private Connection connection = null;

    public void createConnection(String[] args) throws ClassNotFoundException, SQLException {
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Getting records...");
            statement = connection.createStatement();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void select() {


        try {
            Statement s = connection.createStatement();
            DatabaseMetaData md = connection.getMetaData();
            String tableName = md.getTables(null, null, "%",null).getString(3);
            ResultSet res = s.executeQuery("SELECT * FROM " + tableName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
