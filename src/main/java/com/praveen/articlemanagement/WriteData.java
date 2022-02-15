package com.praveen.articlemanagement;

import java.sql.*;

public class WriteData {
    public static void signUp(String username,String password) throws Exception{    //signs up the user
        try {
//            System.out.println(username + " " + password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
            String query = "INSERT INTO user (username,password,premium) VALUES (?,?,'NO')";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.execute();
        }
        catch (Exception e){
            System.out.println(e);
            throw new Exception();
        }
    }

    public static void createArticle(int user_id,String content,String created,String type) throws Exception {  //creates article
        try{
            int article_id = ReadData.getArticleId();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
            String query = "INSERT INTO articles (article_id, content, created, user_id,type) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);
            stmt.setString(2,content);
            stmt.setTimestamp(3,Timestamp.valueOf(created));
            stmt.setInt(4,user_id);
            stmt.setString(5,type);
            stmt.execute();


        } catch (Exception e){
            System.out.println(e);
            throw new Exception();
        }
    }
}
