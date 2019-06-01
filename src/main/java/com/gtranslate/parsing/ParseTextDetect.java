/*    */ package com.gtranslate.parsing;
/*    */ 
/*    */ import com.gtranslate.text.Text;
/*    */ import com.gtranslate.utils.WebUtils;
/*    */ 
/*    */ public class ParseTextDetect implements Parse
/*    */ {
/*    */   private StringBuilder url;
/*    */   private Text input;
/*    */   
/*    */   public ParseTextDetect(Text input)
/*    */   {
/* 13 */     this.input = input;
/*    */   }
/*    */   
/*    */ 
/*    */   public void appendURL()
/*    */   {
/* 19 */     this.url = new StringBuilder("http://www.google.com/uds/GlangDetect?");
/* 20 */     this.url.append("v=1.0&");
/* 21 */     this.url.append("q=" + this.input.getLanguage().replace(" ", "%20"));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void parse()
/*    */   {
/* 28 */     appendURL();
/* 29 */     String result = WebUtils.source(this.url.toString());
/* 30 */     this.input.setLanguage(result.split(",")[0].split(":")[2].replace("\"", ""));
/*    */   }
/*    */ }


/* Location:              C:\Users\Cheese\Downloads\Google Translate.jar!\com\gtranslate\parsing\ParseTextDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */