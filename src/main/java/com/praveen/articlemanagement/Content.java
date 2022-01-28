package com.praveen.articlemanagement;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "content", value = "/content")
public class Content extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{

        PrintWriter out = res.getWriter();

        try{
            int count = ReadData.showArticles();
            System.out.println(Global.jArray);
            out.write(Global.jArray.toString());
            Global.jArray.clear();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
