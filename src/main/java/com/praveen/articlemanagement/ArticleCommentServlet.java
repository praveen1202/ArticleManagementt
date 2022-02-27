package com.praveen.articlemanagement;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "articleComment",value = "/JSP/articleid/article-comment")
public class ArticleCommentServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        try{
            int user_id = Integer.parseInt(req.getParameter("user_id"));
            int article_id = Integer.parseInt(req.getParameter("article_id"));
            String comment_created = req.getParameter("comment_created");
            String user_comment = req.getParameter("user_comment");

            int comment_id = ReadData.getCommentId(user_id,article_id);

            WriteData.commentArticle(user_id,article_id,comment_created,user_comment,comment_id);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
