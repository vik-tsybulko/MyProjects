package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.sqlite.JDBC");
            //установка соединения
            connection = DriverManager.getConnection("jdbc:sqlite:MyBD.s3db");
            //создание стейтмент
            statement = connection.createStatement();
            //віполнение запроса
            statement.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
            statement.execute("CREATE TABLE if not exists 'users22' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");


            statement.execute("insert into 'users22' ('name', 'phone') VALUES ('Masha', 456123)");
            statement.execute("insert into 'users22' ('name', 'phone') VALUES ('Petya', 125453)");
            statement.execute("insert into 'users22' ('name', 'phone') VALUES ('Vasya', 321789)");
            resultSet = statement.executeQuery("select * from users");
            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String  name = resultSet.getString("name");
                String  phone = resultSet.getString("phone");
                System.out.println( "ID = " + id );
                System.out.println( "name = " + name );
                System.out.println( "phone = " + phone );
                System.out.println();
            }
            System.out.println(String.valueOf(resultSet));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (connection != null) connection.close();
                    if (statement != null) statement.close();
                    if (resultSet != null) resultSet.close();

                }catch (SQLException e) {
                    e.printStackTrace();

            }
        }
    }
}
