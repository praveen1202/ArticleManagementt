package com.praveen.articlemanagement;

import java.io.*;
import org.json.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "content", value = "/content")
public class Content extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{

        PrintWriter out = res.getWriter();

        try{
            JSONArray jArray = ReadData.showArticles();        //get article content from the database
            out.write(jArray.toString());     //output the res in json
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
