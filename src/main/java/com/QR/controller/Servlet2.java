package com.QR.controller;

import com.QR.beans.User;
import com.QR.model.DB;
import com.QR.model.Pair;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@WebServlet(
        name = "Servlet2",
        urlPatterns = "/servlog"
)
public class Servlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String pass=req.getParameter("pass");
        User user=new User(email,pass);
        if(DB.checkLog(user)){
            Pair pp =DB.readData(email);
            req.setAttribute("name",pp.name);
            String Base64img  = Base64.getEncoder().encodeToString(pp.b);
            req.setAttribute("image",Base64img);
            req.setAttribute("Again","Again");

            HttpSession session=req.getSession();
            RequestDispatcher rd=req.getRequestDispatcher("/jsp/QRpage.jsp");

            rd.forward(req,resp);
        } else{
            String s="Invalid email/password";
            req.setAttribute("warn",s);
            RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
            rd.forward(req,resp);
        }

    }
}
