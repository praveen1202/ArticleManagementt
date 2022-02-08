package com.praveen.articlemanagement;

import java.sql.*;

public class WriteData {
    public static void signUp(String username,String password) throws Exception{
        try {
//            System.out.println(username + " " + password);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
            String query = "INSERT INTO user (username,password,premium) VALUES (?,?,'NO')";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.execute();
        }
        catch (Exception e){
//            System.out.println(e);
            throw new Exception();
        }
    }
}
