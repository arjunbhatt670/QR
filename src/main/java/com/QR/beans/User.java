package com.QR.beans;

import java.io.InputStream;

public class User {
    public String QRid;
    public String name;
    public String email;
    public String pass;
    public InputStream is;

    public User(String name, String QRid,String email,String pass,InputStream is){
            this.name=name;
            this.QRid=QRid;
            this.email=email;
            this.pass=pass;
            this.is=is;
    }
    public User(String email,String pass){
        this.email=email;
        this.pass=pass;
    }

}
