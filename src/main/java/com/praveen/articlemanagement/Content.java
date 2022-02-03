package com.praveen.articlemanagement;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "content", value = "/content")
public class Content extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{

        PrintWriter out = res.getWriter();

        try{
            ReadData.showArticles();
//            System.out.println(Global.jArray);
            out.write(Global.jArray.toString());
            Global.jArray.clear();
//            System.out.println(Global.jArray);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
