package com.walle.girl;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://119.29.115.175:3306/girl","root","1234qwerQWER!@#$");
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
