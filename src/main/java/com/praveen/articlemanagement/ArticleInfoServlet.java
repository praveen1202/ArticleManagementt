package com.praveen.articlemanagement;

import java.io.*;
import org.json.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "articleInfo",value = "/JSP/articleid/article-info")
public class ArticleInfoServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        try {
            int article_id = Integer.parseInt(req.getParameter("article_id"));
            int user_id = Integer.parseInt(req.getParameter("user_id"));

            JSONArray jArray = new JSONArray();

            JSONObject article = ReadData.getArticle(article_id);
            jArray.put(article);
            JSONObject likeInfo = ReadData.getLikeInfo(user_id,article_id);
            jArray.put(likeInfo);
            JSONObject comments = ReadData.getComments(article_id);
            jArray.put(comments);
            JSONObject likes = ReadData.getLikes(article_id);
            jArray.put(likes);

            out.write(jArray.toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
