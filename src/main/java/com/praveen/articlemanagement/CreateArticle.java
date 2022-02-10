package com.praveen.articlemanagement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "createArticle", value = "/create-article")
public class CreateArticle extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res){

        HttpSession session = req.getSession();

        int user_id = Integer.parseInt(session.getAttribute("user_id").toString());


        String content = req.getParameter("title") + "....." + req.getParameter("content");
        String premium = req.getParameter("premium");
        String created = req.getParameter("created");
        String type;

        if(premium.equals("YES")){
            type = "PREMIUM";
        }
        else {
            type = "FREE";
        }
        try {
            WriteData.createArticle(user_id,content,created,type);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
