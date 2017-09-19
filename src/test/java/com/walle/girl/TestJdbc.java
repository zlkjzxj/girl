package com.walle.girl;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgirl","root","root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from girl");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
