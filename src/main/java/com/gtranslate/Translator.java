/*    */ package com.gtranslate;
/*    */ 
/*    */ import com.gtranslate.parsing.Parse;
/*    */ import com.gtranslate.parsing.ParseTextDetect;
/*    */ import com.gtranslate.parsing.ParseTextTranslate;
/*    */ import com.gtranslate.text.Text;
/*    */ import com.gtranslate.text.TextTranslate;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Translator
/*    */ {
/*    */   private static Translator translator;
/*    */   
/*    */   public static synchronized Translator getInstance()
/*    */   {
/* 17 */     if (translator == null) {
/* 18 */       translator = new Translator();
/*    */     }
/* 20 */     return translator;
/*    */   }
/*    */   
/*    */ 
/*    */   public void translate(TextTranslate textTranslate)
/*    */   {
/* 26 */     Parse parse = new ParseTextTranslate(textTranslate);
/* 27 */     parse.parse();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String translate(String text, String languageInput, String languageOutput)
/*    */   {
/* 34 */     Text input = new Text(text, languageInput);
/* 35 */     TextTranslate textTranslate = new TextTranslate(input, languageOutput);
/* 36 */     Parse parse = new ParseTextTranslate(textTranslate);
/* 37 */     parse.parse();
/* 38 */     return textTranslate.getOutput().getText();
/*    */   }
/*    */   
/*    */ 
/*    */   public String detect(String text)
/*    */   {
/* 44 */     Text input = new Text(text);
/* 45 */     Parse parse = new ParseTextDetect(input);
/* 46 */     parse.parse();
/* 47 */     return input.getLanguage();
/*    */   }
/*    */ }


/* Location:              C:\Users\Cheese\Downloads\Google Translate.jar!\com\gtranslate\Translator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */