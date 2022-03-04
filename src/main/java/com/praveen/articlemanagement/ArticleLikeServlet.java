package com.praveen.articlemanagement;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "articleLike",value = "/JSP/articleid/article-like")
public class ArticleLikeServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try {
            HttpSession session = req.getSession();
            int user_id = Integer.parseInt(session.getAttribute("user_id").toString());

            int article_id = Integer.parseInt(req.getParameter("article_id"));
            int like_id = ReadData.getLikeId(article_id);

            WriteData.likeArticle(user_id,article_id,like_id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
