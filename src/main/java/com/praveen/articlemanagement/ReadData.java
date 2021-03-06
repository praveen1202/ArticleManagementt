package com.praveen.articlemanagement;

import java.sql.*;
import org.json.*;

public class ReadData {
    public static JSONArray showArticles() throws Exception{     //shows article from database
        try {
            int article_id,views,user_id;
            String content,created,username;

            Connection con = DatabaseConnection.initializeDatabase();

            String query = "SELECT article_id,content,views,user_id,created FROM articles WHERE type='FREE' ORDER BY created DESC LIMIT 5";
            PreparedStatement stmt = con.prepareStatement(query);

            JSONArray jArray = new JSONArray();
            

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                JSONObject jObject = new JSONObject();

                article_id = rs.getInt(1);
                content = rs.getString(2);
                views = rs.getInt(3);
                user_id = rs.getInt(4);
                created = rs.getString(5);

                username = ReadData.getUserName(user_id);

                jObject.put("article_id",article_id);
                jObject.put("content",content);
                jObject.put("views",views);
                jObject.put("username",username);
                jObject.put("created",created);
                
                jArray.put(jObject);
            }
            con.close();
            return jArray;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    public static JSONObject searchUser(String username, String password) throws Exception{    //function for logging in (sends user_id and premium in json)
        try{
            int user_id;
            String premium;
            JSONObject jObject = new JSONObject();

            Connection con = DatabaseConnection.initializeDatabase();
            String query = "SELECT user_id,premium FROM user WHERE username = ? AND password = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2,password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user_id = rs.getInt(1);
                premium = rs.getString(2);

                jObject.put("user_id",user_id);
                jObject.put("premium",premium);
            }
            con.close();
            return jObject;

        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    public static int getArticleId() throws Exception {     //function to get the highest article_id so that it is unique from others
        try{
            int article_id = 0;

            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "SELECT MAX(article_id) FROM articles";

            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                article_id = rs.getInt(1);
            }
            con.close();
            return ++article_id;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

    }

    public static boolean searchArticle(int article_id){
        try{
            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "SELECT article_id FROM articles WHERE article_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                con.close();
                return true;
            }
            con.close();
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static JSONObject getArticle(int article_id) throws Exception {
        try{
            JSONObject jObject = new JSONObject();

            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "SELECT content,views,user_id,created FROM articles WHERE article_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                jObject.put("content",rs.getString(1));
                jObject.put("views",rs.getInt(2));


                jObject.put("user_name",ReadData.getUserName(rs.getInt(3)));
                jObject.put("created",rs.getString(4));
            }
            con.close();
            return jObject;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    public static String getUserName(int user_id) throws Exception {
        try {
            String username;

            Connection con = DatabaseConnection.initializeDatabase();
            
            String query = "SELECT username FROM user WHERE user_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,user_id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                username = rs.getString(1);
            }
            else {
                throw new Exception();
            }
            con.close();
            return username;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static int getLikeId(int article_id) throws Exception {
        try{
            int like_id = 0;

            Connection con = DatabaseConnection.initializeDatabase();

            String query = "SELECT MAX(like_id) FROM article_like WHERE article_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                like_id = rs.getInt(1);
            }
            con.close();
            return ++like_id;

        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static JSONObject getLikeInfo(int user_id,int article_id) throws Exception {
        try{
            JSONObject jObject = new JSONObject();

            Connection con = DatabaseConnection.initializeDatabase();

            String query = "SELECT like_id FROM article_like WHERE user_id = ? AND article_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,user_id);
            stmt.setInt(2,article_id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                jObject.put("liked","yes");
            }
            else{
                jObject.put("liked","no");
            }
            con.close();
            return jObject;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static int getCommentId(int user_id,int article_id) throws Exception {
        try{
            int comment_id = 0;

            Connection con = DatabaseConnection.initializeDatabase();

            String query = "SELECT MAX(comment_id) FROM article_comment WHERE article_id = ? AND user_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);
            stmt.setInt(2,user_id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                comment_id = rs.getInt(1);
            }
            con.close();
            return ++comment_id;

        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static JSONObject getComments(int article_id) throws Exception {
        try{
            JSONArray jArray = new JSONArray();
            JSONObject jObject = new JSONObject();

            Connection con = DatabaseConnection.initializeDatabase();

            String query = "SELECT user_id,comment_text FROM article_comment WHERE article_id = ? ORDER BY comment_created LIMIT 10";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                JSONObject data = new JSONObject();
                data.put("user_name",ReadData.getUserName(rs.getInt(1)));
                data.put("comment_text",rs.getString(2));

                jArray.put(data);
            }
            con.close();
            jObject.put("comments",jArray);
            return jObject;

        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static JSONObject getLikes(int article_id) throws Exception {
        try{
            JSONObject jObject = new JSONObject();

            Connection con = DatabaseConnection.initializeDatabase();


            String query = "SELECT likes FROM articles WHERE article_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,article_id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                jObject.put("likes",rs.getInt(1));
            }
            con.close();
            return jObject;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    protected static String checkPremium(int user_id) throws Exception {
        try{
            String premium = new String();
            Connection con = DatabaseConnection.initializeDatabase();

            String query = "SELECT premium FROM user WHERE user_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,user_id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                premium = rs.getString(1);
            }
            con.close();
            return premium;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }
}