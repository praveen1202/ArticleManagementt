package com.praveen.articlemanagement;

import java.io.*;
import java.util.regex.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ArticleIdServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        int article_id;
        String url = req.getRequestURL().toString();
        String[] arr = url.split("articleid/");

        if(Pattern.matches("[0-9]+",arr[1])) {
            article_id = Integer.parseInt(arr[1]);
            if(ReadData.searchArticle(article_id)){
                req.setAttribute("article_id", article_id);
                req.getRequestDispatcher("../read-article.jsp").forward(req, res);
            }
            else{
                res.sendRedirect("../../index.jsp");    //illegal call,have to raise error
            }
        }
        else{
            res.sendRedirect("../../index.jsp");    //have to raise error
        }


    }
}
