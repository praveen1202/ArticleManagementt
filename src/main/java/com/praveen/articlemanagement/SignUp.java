package com.praveen.articlemanagement;

import java.io.*;


import org.json.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name="signUp",value="/sign-up")
public class SignUp extends HttpServlet{

//    @Override

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("application/json");
        String username = req.getParameter("sign-username");
        String password = req.getParameter("sign-password-1");
        JSONObject object = new JSONObject();

        PrintWriter out = res.getWriter();

        try{
            WriteData.signUp(username,password);    //creates user
            object.put("status","success");
        }
        catch (Exception e){
            object.put("status","failure");
            System.out.println(object);
        }
        out.write(object.toString());
    }
}
