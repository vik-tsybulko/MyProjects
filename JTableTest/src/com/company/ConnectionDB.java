package com.company;

import java.sql.*;

/**
 * Created by viktor on 01.02.17.
 */
public class ConnectionDB {
    ConnectionDB(){

    }
    private String URLDB = "src/com.company/4.3sdb";

    private Connection connection;


    public Connection getConnection(){
        return connection;
    }
    public void init (String url){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet resultSetQuery (String query){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void sqlQuery(String query){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
