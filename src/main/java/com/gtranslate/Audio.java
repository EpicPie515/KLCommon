/*    */ package com.gtranslate;
/*    */ 
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Audio
/*    */ {
/*    */   private static Audio audio;
/*    */   
/*    */   public static synchronized Audio getInstance()
/*    */   {
/* 20 */     if (audio == null) {
/* 21 */       audio = new Audio();
/*    */     }
/* 23 */     return audio;
/*    */   }
/*    */   
/*    */   public InputStream getAudio(String text, String languageOutput)
/*    */     throws IOException
/*    */   {
/* 29 */     URL url = new URL("http://translate.google.com/translate_tts?q=" + 
/* 30 */       text.replace(" ", "%20") + "&tl=" + languageOutput);
/* 31 */     URLConnection urlConn = url.openConnection();
/* 32 */     urlConn.addRequestProperty("User-Agent", 
/* 33 */       "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
/* 34 */     InputStream audioSrc = urlConn.getInputStream();
/* 35 */     return new BufferedInputStream(audioSrc);
/*    */   }
/*    */ }