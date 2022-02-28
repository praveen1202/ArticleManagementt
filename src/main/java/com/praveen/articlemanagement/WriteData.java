package com.praveen.articlemanagement;

import java.sql.*;

public class WriteData {
    public static void signUp(String username,String password,String email) throws Exception{    //signs up the user
        try {
//            System.out.println(username + " " + password);
            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "INSERT INTO user (username,password,email_id,premium) VALUES (?,?,?,'NO')";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.setString(3,email);
            stmt.execute();
            con.close();

        }
        catch (Exception e){
            System.out.println(e);
            throw new Exception();
        }
    }

    public static void createArticle(int user_id,String content,String created,String type) throws Exception {  //creates article
        try{
            int article_id = ReadData.getArticleId();

            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "INSERT INTO articles (article_id, content, created, user_id,type) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);
            stmt.setString(2,content);
            stmt.setTimestamp(3,Timestamp.valueOf(created));
            stmt.setInt(4,user_id);
            stmt.setString(5,type);
            stmt.execute();

            con.close();

        } catch (Exception e){
            System.out.println(e);
            throw new Exception();
        }
    }

    public static void likeArticle(int user_id,int article_id,int like_id){
        try{
            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "INSERT INTO article_like (like_id,article_id,user_id) VALUES (?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,like_id);
            stmt.setInt(2,article_id);
            stmt.setInt(3,user_id);

            stmt.execute();
            con.close();

            WriteData.updateLike(article_id);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected static void commentArticle(int user_id,int article_id,String comment_created,String comment_text,int comment_id){
        try{
            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "INSERT INTO article_comment (user_id,article_id,comment_created,comment_text,comment_id) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,user_id);
            stmt.setInt(2,article_id);
            stmt.setTimestamp(3,Timestamp.valueOf(comment_created));
            stmt.setString(4,comment_text);
            stmt.setInt(5,comment_id);

            stmt.execute();
            con.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected static void updateLike(int article_id){
        try{
            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "UPDATE articles SET likes = likes + 1 WHERE article_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);

            stmt.execute();
            con.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
