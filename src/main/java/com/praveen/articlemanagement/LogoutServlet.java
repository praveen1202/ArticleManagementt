package com.praveen.articlemanagement;



import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name="logOut",value="/log-out")
public class LogoutServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("name");        //removes attributes and invalidates the session
        session.invalidate();
        res.sendRedirect("index.jsp");          //redirects to home page
    }
}