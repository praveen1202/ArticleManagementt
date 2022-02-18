package com.praveen.articlemanagement;

import java.io.*;
import org.json.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "articleInfo",value = "/article-info")
public class ArticleInfoServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        try {
            int article_id = Integer.parseInt(req.getParameter("article_id"));
            JSONObject jObject = ReadData.getArticle(article_id);
            out.write(jObject.toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
