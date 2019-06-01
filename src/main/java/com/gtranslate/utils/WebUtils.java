/*    */ package com.gtranslate.utils;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ 
/*    */ public class WebUtils
/*    */ {
/*    */   public static String source(String urlSite)
/*    */   {
/* 14 */     StringBuilder result = new StringBuilder();
/*    */     
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 20 */       URL url = new URL(urlSite);
/* 21 */       URLConnection urlConn = url.openConnection();
/* 22 */       urlConn.addRequestProperty("User-Agent", 
/* 23 */         "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
/* 24 */       java.io.Reader reader = new InputStreamReader(urlConn.getInputStream(), 
/* 25 */         "utf-8");
/* 26 */       BufferedReader br = new BufferedReader(reader);
/*    */       
/*    */       int byteRead;
/* 29 */       while ((byteRead = br.read()) != -1) {
/* 30 */         result.append((char)byteRead);
/*    */       }
/*    */     } catch (MalformedURLException e) {
/* 33 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 35 */       e.printStackTrace();
/*    */     }
/* 37 */     return result.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Cheese\Downloads\Google Translate.jar!\com\gtranslat\\utils\WebUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */