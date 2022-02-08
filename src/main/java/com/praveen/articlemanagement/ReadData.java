package com.praveen.articlemanagement;

import java.sql.*;
import org.json.*;

public class ReadData {
    public static void showArticles() throws Exception{
        try {
            int article_id,views,user_id;
            String content,created;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
            String query = "SELECT article_id,content,views,user_id,created FROM articles WHERE type='FREE' ORDER BY created DESC LIMIT 5";
            PreparedStatement stmt = con.prepareStatement(query);
            JSONObject obj = new JSONObject();
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                article_id = rs.getInt(1);
                content = rs.getString(2);
                views = rs.getInt(3);
                user_id = rs.getInt(4);
                created = rs.getString(5);

                obj.put("article_id",article_id);
                obj.put("content",content);
                obj.put("views",views);
                obj.put("user_id",user_id);
                obj.put("created",created);

                JSONObject copyObj = new JSONObject(obj.toString());            //deep copies the json object obj into copyObj to avoid discrepancies over storing json object in json array
                Global.jArray.put(copyObj);
                obj.clear();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    public static void searchUser(String username,String password) throws Exception{
        try{
            int user_id;
            String premium;
            JSONObject obj = new JSONObject();

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
            String query = "SELECT user_id,premium FROM user WHERE username = ? AND password = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2,password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user_id = rs.getInt(1);
                premium = rs.getString(2);

                obj.put("user_id",user_id);
                obj.put("premium",premium);
                Global.jObj = obj;
            }
        }
        catch (Exception e){
            System.out.println(e);
            throw new Exception();
        }
    }

}
