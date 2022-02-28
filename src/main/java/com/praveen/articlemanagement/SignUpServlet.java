package com.praveen.articlemanagement;

import java.io.*;


import org.json.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name="signUp",value="/sign-up")
public class SignUpServlet extends HttpServlet{

//    @Override

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
//        res.setContentType("application/json");
        JSONObject status = new JSONObject();
        JSONObject jObject;

        PrintWriter out = res.getWriter();

        try{
            String username = req.getParameter("sign-username");
            String password = req.getParameter("sign-password-1");
            String email = req.getParameter("email-id");

            WriteData.signUp(username,password,email);    //creates user
            jObject = ReadData.searchUser(username,password);

            HttpSession session = req.getSession();         //creates session
            session.setAttribute("user_id",jObject.get("user_id"));
            session.setAttribute("name",username);
            status.put("status","success");
        }
        catch (Exception e){
            e.printStackTrace();
            status.put("status","failure");
        }
        out.write(status.toString());
    }
}
