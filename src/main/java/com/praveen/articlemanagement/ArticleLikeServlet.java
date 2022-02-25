package com.praveen.articlemanagement;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "articleLike",value = "/JSP/articleid/article-like")
public class ArticleLikeServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try {
            int user_id = Integer.parseInt(req.getParameter("user_id"));
            int article_id = Integer.parseInt(req.getParameter("article_id"));
            WriteData.likeArticle(user_id,article_id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
