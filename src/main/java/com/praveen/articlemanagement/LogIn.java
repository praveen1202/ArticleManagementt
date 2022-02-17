package com.praveen.articlemanagement;

import java.io.*;


import org.json.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name="logIn",value="/log-in")
public class LogIn extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {

        String username = req.getParameter("log-username");
        String password = req.getParameter("log-password");
        PrintWriter out = res.getWriter();
        JSONObject jObject = new JSONObject();
        try{

            jObject = ReadData.searchUser(username,password);         //searches if username and password matches in the database

            HttpSession session = req.getSession();         //creates session
            session.setAttribute("user_id",jObject.get("user_id"));
            session.setAttribute("name",username);

            jObject.put("status","success");
            out.write(jObject.toString());

        }
        catch (Exception e){

            e.printStackTrace();
            jObject.put("status","failure");
            out.write(jObject.toString());
        }
    }
}
