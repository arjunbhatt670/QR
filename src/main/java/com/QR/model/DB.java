package com.QR.model;

import com.QR.beans.User;

import java.io.InputStream;
import java.sql.*;

public class DB {
    static Connection con=GetConn.getConnection();

    public static boolean checkNew(User newuser){
        String email=newuser.email;
int i=1;
        try {
            Statement stmt=con.createStatement();
            String ee=String.format("select * from RegTable where email='%s'",email);
            ResultSet rs=stmt.executeQuery(ee);
            while(rs.next()){
                if(rs.getString("email")!=null){
                    i=0;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i==1)
            return true;
        else{
           // GetConn.closeConn(con);
            return false;
        }

    }

    public static boolean checkLog(User user){
        String email=user.email;
        int i=1;
        try {
            Statement stmt=con.createStatement();
            String ee=String.format("select * from regtable where email='%s'",email);
            ResultSet rs=stmt.executeQuery(ee);
            while(rs.next()){
                if(rs.getString("password").equals(user.pass)){
                    i=0;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i==1){
           // GetConn.closeConn(con);
            return false;
        } else
            return true;

    }

    public static void insert(User newuser) {

        try {
            PreparedStatement stmt=con.prepareStatement("insert into regTable(name,email,QRid,password,QRimage) values(?,?,?,?,?)");
            stmt.setString(1,newuser.name);
            stmt.setString(2,newuser.email);
            stmt.setString(3,newuser.QRid);
            stmt.setString(4,newuser.pass);
            stmt.setBinaryStream(5,(InputStream)newuser.is);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    //GetConn.closeConn(con);
    }

    public static Pair readData(String email){
        String name = null;
        byte[] b=new byte[64*1024];
        Blob blob;
        try {
            String ee=String.format("select * from RegTable where email='%s'",email);
            PreparedStatement stmt=con.prepareStatement(ee);
            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                name=rs.getString("name");
                blob=rs.getBlob("QRimage");
                b=blob.getBytes(1,(int)blob.length());
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Pair(b,name);

    }
}


