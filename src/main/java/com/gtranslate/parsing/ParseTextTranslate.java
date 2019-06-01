/*    */ package com.gtranslate.parsing;
/*    */ 
/*    */ import com.gtranslate.text.Text;
/*    */ import com.gtranslate.text.TextTranslate;
/*    */ 
/*    */ public class ParseTextTranslate implements Parse
/*    */ {
/*    */   private TextTranslate textTranslate;
/*    */   private StringBuilder url;
/*    */   
/*    */   public ParseTextTranslate(TextTranslate textTranslate)
/*    */   {
/* 13 */     this.textTranslate = textTranslate;
/*    */   }
/*    */   
/*    */   public void parse()
/*    */   {
/* 18 */     appendURL();
/* 19 */     String result = com.gtranslate.utils.WebUtils.source(this.url.toString());
/* 20 */     String[] split = result.replace("[", "").replace("]", "").replace("\"", 
/* 21 */       "").split(",");
/* 22 */     Text output = this.textTranslate.getOutput();
/* 23 */     output.setText(split[0]);
/*    */   }
/*    */   
/*    */   public TextTranslate getTextTranslate()
/*    */   {
/* 28 */     return this.textTranslate;
/*    */   }
/*    */   
/*    */   public void appendURL()
/*    */   {
/* 33 */     Text input = this.textTranslate.getInput();
/* 34 */     Text output = this.textTranslate.getOutput();
/* 35 */     this.url = new StringBuilder("http://translate.google.com.br/translate_a/t?");
/* 36 */     this.url.append("client=t&text=" + input.getText().replace(" ", "%20"));
/* 37 */     this.url.append("&hl=" + input.getLanguage());
/* 38 */     this.url.append("&sl=" + input.getLanguage());
/* 39 */     this.url.append("&tl=" + output.getLanguage());
/* 40 */     this.url.append("&multires=1&prev=btn&ssel=0&tsel=0&sc=1");
/*    */   }
/*    */ }


/* Location:              C:\Users\Cheese\Downloads\Google Translate.jar!\com\gtranslate\parsing\ParseTextTranslate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */