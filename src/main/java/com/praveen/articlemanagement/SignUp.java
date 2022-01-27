package com.praveen.articlemanagement;

import java.io.*;

import org.jetbrains.annotations.NotNull;
import org.json.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name="signUp",value="/sign-up")
public class SignUp extends HttpServlet{

//    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("application/json");
        String username = req.getParameter("username").toString();
        String password = req.getParameter("password1").toString();
        JSONObject object = new JSONObject();
        System.out.println(username);

        PrintWriter out = res.getWriter();

        try{
            WriteData.signUp(username,password);
            object.put("status","Success!");
        }
        catch (Exception e){
            object.put("status","Failure!");
        }
        out.write(object.toString());
    }
}
