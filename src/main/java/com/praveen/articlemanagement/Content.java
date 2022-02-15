package com.praveen.articlemanagement;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "content", value = "/content")
public class Content extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{

        PrintWriter out = res.getWriter();

        try{
            ReadData.showArticles();        //get article content from the database
//            System.out.println(Global.jArray);
            out.write(Global.jArray.toString());     //output the res in json
            Global.jArray.clear();
//            System.out.println(Global.jArray);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
