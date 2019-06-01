/*    */ package com.gtranslate.text;
/*    */ 
/*    */ public class Text {
/*    */   private String text;
/*    */   private String language;
/*    */   
/*    */   public Text(String text, String language) {
/*  8 */     this.text = text;
/*  9 */     this.language = language;
/*    */   }
/*    */   
/*    */   public Text(String language) {
/* 13 */     this.language = language;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 17 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(String text) {
/* 21 */     this.text = text;
/*    */   }
/*    */   
/*    */   public String getLanguage() {
/* 25 */     return this.language;
/*    */   }
/*    */   
/*    */   public void setLanguage(String language) {
/* 29 */     this.language = language;
/*    */   }
/*    */ }


/* Location:              C:\Users\Cheese\Downloads\Google Translate.jar!\com\gtranslate\text\Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */