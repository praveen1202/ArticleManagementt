package com.praveen.articlemanagement;

import java.io.*;


import org.json.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name="logIn",value="/log-in")
public class LogIn extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        String username = req.getParameter("log-username");
        String password = req.getParameter("log-password");
        PrintWriter out = res.getWriter();

        try{

            ReadData.searchUser(username,password);

            Global.jObj.put("status","success");
            out.write(Global.jObj.toString());

            HttpSession session = req.getSession();
            session.setAttribute("name",username);
            session.setAttribute("user_id",Global.jObj.get("user_id"));

            Global.jObj.clear();
        }
        catch (Exception e){

            System.out.println(e);
            Global.jObj.put("status","failure");
            out.write(Global.jObj.toString());
            Global.jObj.clear();
        }
    }
}
