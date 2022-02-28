package com.praveen.articlemanagement;

import java.sql.*;

public class DatabaseConnection {
    protected static Connection initializeDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/articleManagement";
        String user = "sample";
        String password = "sample";
        Connection con = DriverManager.getConnection(url, user, password);

        return con;
    }
}
