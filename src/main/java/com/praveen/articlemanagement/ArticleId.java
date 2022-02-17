package com.praveen.articlemanagement;

import java.io.*;
import java.util.regex.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ArticleId extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        int article_id;
        String url = req.getRequestURL().toString();
        String[] arr = url.split("articleid/");
        System.out.println(arr.length + " " + url);
        System.out.println(Pattern.matches("[0-9]+",arr[1]));
        if(Pattern.matches("[0-9]+",arr[1])) {
            try {
                article_id = Integer.parseInt(arr[1]);
                req.setAttribute("article_id", article_id);
                req.getRequestDispatcher("../read-article.jsp").forward(req, res);
            } catch (Exception e) {
                System.out.println(e + " outer try");
                res.sendRedirect("../../index.jsp");
            }
        }
        else {
            res.sendRedirect("../../index.jsp");
        }

    }
}
