package com.QR.beans;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


//@WebServlet(
//        name = "qrservlet",
//        urlPatterns = "/qrservlet"
//)

public class QRmaker{

    public ByteArrayOutputStream QRmake(String name){
        String myCodeText = name;
        int size = 250;
        String fileType = "jpg";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
         try {
             Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
             hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
             hintMap.put(EncodeHintType.MARGIN, 1);


             hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

             QRCodeWriter qrCodeWriter = new QRCodeWriter();
             BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size,
                     size, hintMap);
             int CrunchifyWidth = byteMatrix.getWidth();
             BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
                     BufferedImage.TYPE_INT_RGB);
             image.createGraphics();

             Graphics2D graphics = (Graphics2D) image.getGraphics();
             graphics.setColor(Color.WHITE);
             graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
             graphics.setColor(Color.BLACK);

             for (int i = 0; i < CrunchifyWidth; i++) {
                 for (int j = 0; j < CrunchifyWidth; j++) {
                     if (byteMatrix.get(i, j)) {
                         graphics.fillRect(i, j, 1, 1);
                     }
                 }
             }

             ImageIO.write(image, fileType, os);

         } catch (IOException e){
             e.printStackTrace();
         } catch (WriterException e){
             e.printStackTrace();
         }
//               request.setAttribute("image",image);
//               RequestDispatcher reqd=request.getRequestDispatcher("/jsp/register.jsp");
//                       reqd.forward(request,response);


        System.out.println("\n\nYou have successfully created QR Code.");
        return os;
    }
}