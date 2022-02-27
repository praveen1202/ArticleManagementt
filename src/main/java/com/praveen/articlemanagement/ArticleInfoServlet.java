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

            JSONObject jObject1 = ReadData.getArticle(article_id);
            jArray.put(jObject1);
            JSONObject jObject2 = ReadData.getLikeInfo(user_id,article_id);
            jArray.put(jObject2);
            JSONObject jObject3 = ReadData.getComments(article_id);
            jArray.put(jObject3);
            out.write(jArray.toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
