package com.praveen.articlemanagement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.json.JSONObject;

@WebServlet(name = "getPremium",value={"/apply-premium","/JSP/articleid/apply-premium","/JSP/apply-premium"})
public class PremiumServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res){
        JSONObject jObject = new JSONObject();
        try{
            HttpSession session = req.getSession();
            int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
            WriteData.applyPremium(user_id);
            res.sendRedirect("http://localhost:8080/articleManagement/index.jsp");          //redirects to home page
        }
        catch(Exception e){

            e.printStackTrace();
        }
    }
}
