package com.praveen.articlemanagement;



import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name="logOut",value="/log-out")
public class Logout extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("name");
        session.invalidate();
        res.sendRedirect("index.jsp");
    }
}
