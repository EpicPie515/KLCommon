/*    */ package com.gtranslate.text;
/*    */ 
/*    */ public class TextTranslate {
/*    */   private Text input;
/*    */   private Text output;
/*    */   
/*    */   public TextTranslate(Text input, String loutput) {
/*  8 */     this.input = input;
/*  9 */     this.output = new Text(loutput);
/*    */   }
/*    */   
/*    */   public TextTranslate(Text input, Text output) {
/* 13 */     this.input = input;
/* 14 */     this.output = output;
/*    */   }
/*    */   
/*    */   public Text getInput() {
/* 18 */     return this.input;
/*    */   }
/*    */   
/*    */   public Text getOutput() {
/* 22 */     return this.output;
/*    */   }
/*    */ }


/* Location:              C:\Users\Cheese\Downloads\Google Translate.jar!\com\gtranslate\text\TextTranslate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */