package com.praveen.articlemanagement;

import java.sql.*;

public class ReadData {
    public static int showArticles() throws Exception{
        try {
            int article_id,views,user_id,count = 0,index = 0;
            String content,created;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/articleManagement", "sample", "sample");
            String query = "SELECT article_id,content,views,user_id,created FROM articles WHERE type='FREE' ORDER BY created DESC LIMIT 5";
            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                article_id = rs.getInt(1);
                content = rs.getString(2);
                views = rs.getInt(3);
                user_id = rs.getInt(4);
                created = rs.getString(5);   //have to complete goes to global which has article array
                Global.articles[index] =  new Article(article_id,content,views,user_id,created);
                index++;
                count++;
            }
            return count;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

}
