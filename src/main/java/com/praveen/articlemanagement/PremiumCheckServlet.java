package com.praveen.articlemanagement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "checkPremium",value={"/check-premium","/JSP/articleid/check-premium","/JSP/check-premium"})
public class PremiumCheckServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {

        JSONObject jObject = new JSONObject();
        PrintWriter out = res.getWriter();

        try {
            HttpSession session = req.getSession();
            try{
                if(session.getAttribute("user_id") == null){
                    throw new Exception();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            int user_id = Integer.parseInt(session.getAttribute("user_id").toString());
            String premium = ReadData.checkPremium(user_id);

            jObject.put("premium",premium);
            out.write(jObject.toString());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
