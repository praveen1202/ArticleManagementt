package com.praveen.articlemanagement;

import java.sql.*;
import org.json.*;

public class ReadData {
    public static JSONArray showArticles() throws Exception{     //shows article from database
        try {
            int article_id,views,user_id;
            String content,created;

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");

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

                jObject.put("article_id",article_id);
                jObject.put("content",content);
                jObject.put("views",views);
                jObject.put("user_id",user_id);
                jObject.put("created",created);
                
                jArray.put(jObject);
            }
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

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
            String query = "SELECT MAX(article_id) FROM articles";

            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                article_id = rs.getInt(1);
            }
            return ++article_id;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

    }
}
