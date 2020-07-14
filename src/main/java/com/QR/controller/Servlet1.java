package com.QR.controller;

import com.QR.beans.QRmaker;
import com.QR.beans.User;
import com.QR.model.DB;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.util.Base64;
import java.util.UUID;


@WebServlet(
        name = "Servlet1",
        urlPatterns = "/servreg"
)

public class Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String pass=req.getParameter("pass");
        String uuid = UUID.randomUUID().toString();
        String QRid=uuid.substring(0,8);

        QRmaker make=new QRmaker();
        ByteArrayOutputStream os=make.QRmake(QRid);
        byte[] bytes=os.toByteArray();
        String Base64img  = Base64.getEncoder().encodeToString(bytes);

        InputStream is = new ByteArrayInputStream(bytes);

        User newuser=new User(name,QRid,email,pass,is);
        if(DB.checkNew(newuser)){
            DB.insert(newuser);
            req.setAttribute("name",name);
            req.setAttribute("image",Base64img);

            RequestDispatcher rd=req.getRequestDispatcher("/jsp/QRpage.jsp");

            rd.forward(req,resp);
        }
        else{
            String s="You have Signed up before, please login!!";
            req.setAttribute("warn",s);
            RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
            rd.forward(req,resp);


        }





    }
}
