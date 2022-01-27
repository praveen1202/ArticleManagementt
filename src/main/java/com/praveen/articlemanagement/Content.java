package com.praveen.articlemanagement;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "content", value = "/content")
public class Content extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        try{
            int count = ReadData.showArticles();
            for (int index = 0; index < count;index++){
                System.out.println(Global.articles[index].article_id);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
