/*     */ package com.gtranslate;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class Language {
/*     */   public static final String AFRIKAANS = "af";
/*     */   public static final String ALBANIAN = "sq";
/*     */   public static final String ARABIC = "ar";
/*     */   public static final String ARMENIAN = "hy";
/*     */   public static final String AZERBAIJANI = "az";
/*     */   public static final String BASQUE = "eu";
/*     */   public static final String BELARUSIAN = "be";
/*     */   public static final String BENGALI = "bn";
/*     */   public static final String BULGARIAN = "bg";
/*     */   public static final String CATALAN = "ca";
/*     */   public static final String CHINESE = "zh-CN";
/*     */   public static final String CROATIAN = "hr";
/*     */   public static final String CZECH = "cs";
/*     */   public static final String DANISH = "da";
/*     */   public static final String DUTCH = "nl";
/*     */   public static final String ENGLISH = "en";
/*     */   public static final String ESTONIAN = "et";
/*     */   public static final String FILIPINO = "tl";
/*     */   public static final String FINNISH = "fi";
/*     */   public static final String FRENCH = "fr";
/*     */   public static final String GALICIAN = "gl";
/*     */   public static final String GEORGIAN = "ka";
/*     */   public static final String GERMAN = "de";
/*     */   public static final String GREEK = "el";
/*     */   public static final String GUJARATI = "gu";
/*     */   public static final String HAITIAN_CREOLE = "ht";
/*     */   public static final String HEBREW = "iw";
/*     */   public static final String HINDI = "hi";
/*     */   public static final String HUNGARIAN = "hu";
/*     */   public static final String ICELANDIC = "is";
/*     */   public static final String INDONESIAN = "id";
/*     */   public static final String IRISH = "ga";
/*     */   public static final String ITALIAN = "it";
/*     */   public static final String JAPANESE = "ja";
/*     */   public static final String KANNADA = "kn";
/*     */   public static final String KOREAN = "ko";
/*     */   public static final String LATIN = "la";
/*     */   public static final String LATVIAN = "lv";
/*     */   public static final String LITHUANIAN = "lt";
/*     */   public static final String MACEDONIAN = "mk";
/*     */   public static final String MALAY = "ms";
/*     */   public static final String MALTESE = "mt";
/*     */   public static final String NORWEGIAN = "no";
/*     */   public static final String PERSIAN = "fa";
/*     */   public static final String POLISH = "pl";
/*     */   public static final String PORTUGUESE = "pt";
/*     */   public static final String ROMANIAN = "ro";
/*     */   public static final String RUSSIAN = "ru";
/*     */   public static final String SERBIAN = "sr";
/*     */   public static final String SLOVAK = "sk";
/*     */   public static final String SLOVENIAN = "sl";
/*     */   public static final String SPANISH = "es";
/*     */   public static final String SWAHILI = "sw";
/*     */   public static final String SWEDISH = "sv";
/*     */   public static final String TAMIL = "ta";
/*     */   public static final String TELUGU = "te";
/*     */   public static final String THAI = "th";
/*     */   public static final String TURKISH = "tr";
/*     */   public static final String UKRAINIAN = "uk";
/*     */   public static final String URDU = "ur";
/*     */   public static final String VIETNAMESE = "vi";
/*     */   public static final String WELSH = "cy";
/*     */   public static final String YIDDISH = "yi";
/*     */   public static final String CHINESE_SIMPLIFIED = "zh-CN";
/*     */   public static final String CHINESE_TRADITIONAL = "zh-TW";
/*     */   private static Language language;
/*     */   private HashMap<String, String> hashLanguage;
/*     */   
/*     */   private Language() {
/*  75 */     this.hashLanguage = new HashMap<>();
/*  76 */     init();
/*     */   }
/*     */   
/*     */   public static synchronized Language getInstance() {
/*  80 */     if (language == null) {
/*  81 */       language = new Language();
/*     */     }
/*  83 */     return language;
/*     */   }
/*     */   
/*     */   private void init() {
/*  87 */     this.hashLanguage.put("af", "AFRIKAANS");
/*  88 */     this.hashLanguage.put("sq", "ALBANIAN");
/*  89 */     this.hashLanguage.put("ar", "ARABIC");
/*  90 */     this.hashLanguage.put("hy", "ARMENIAN");
/*  91 */     this.hashLanguage.put("az", "AZERBAIJANI");
/*  92 */     this.hashLanguage.put("eu", "BASQUE");
/*  93 */     this.hashLanguage.put("be", "BELARUSIAN");
/*  94 */     this.hashLanguage.put("bn", "BENGALI");
/*  95 */     this.hashLanguage.put("bg", "BULGARIAN");
/*  96 */     this.hashLanguage.put("ca", "CATALAN");
/*  97 */     this.hashLanguage.put("zh-CN", "CHINESE");
/*  98 */     this.hashLanguage.put("hr", "CROATIAN");
/*  99 */     this.hashLanguage.put("cs", "CZECH");
/* 100 */     this.hashLanguage.put("da", "DANISH");
/* 101 */     this.hashLanguage.put("nl", "DUTCH");
/* 102 */     this.hashLanguage.put("en", "ENGLISH");
/* 103 */     this.hashLanguage.put("et", "ESTONIAN");
/* 104 */     this.hashLanguage.put("tl", "FILIPINO");
/* 105 */     this.hashLanguage.put("fi", "FINNISH");
/* 106 */     this.hashLanguage.put("fr", "FRENCH");
/* 107 */     this.hashLanguage.put("gl", "GALICIAN");
/* 108 */     this.hashLanguage.put("ka", "GEORGIAN");
/* 109 */     this.hashLanguage.put("de", "GERMAN");
/* 110 */     this.hashLanguage.put("el", "GREEK");
/* 111 */     this.hashLanguage.put("gu", "GUJARATI");
/* 112 */     this.hashLanguage.put("ht", "HAITIAN_CREOLE");
/* 113 */     this.hashLanguage.put("iw", "HEBREW");
/* 114 */     this.hashLanguage.put("hi", "HINDI");
/* 115 */     this.hashLanguage.put("hu", "HUNGARIAN");
/* 116 */     this.hashLanguage.put("is", "ICELANDIC");
/* 117 */     this.hashLanguage.put("id", "INDONESIAN");
/* 118 */     this.hashLanguage.put("ga", "IRISH");
/* 119 */     this.hashLanguage.put("it", "ITALIAN");
/* 120 */     this.hashLanguage.put("ja", "JAPANESE");
/* 121 */     this.hashLanguage.put("kn", "KANNADA");
/* 122 */     this.hashLanguage.put("ko", "KOREAN");
/* 123 */     this.hashLanguage.put("la", "LATIN");
/* 124 */     this.hashLanguage.put("lv", "LATVIAN");
/* 125 */     this.hashLanguage.put("lt", "LITHUANIAN");
/* 126 */     this.hashLanguage.put("mk", "MACEDONIAN");
/* 127 */     this.hashLanguage.put("ms", "MALAY");
/* 128 */     this.hashLanguage.put("mt", "MALTESE");
/* 129 */     this.hashLanguage.put("no", "NORWEGIAN");
/* 130 */     this.hashLanguage.put("fa", "PERSIAN");
/* 131 */     this.hashLanguage.put("pl", "POLISH");
/* 132 */     this.hashLanguage.put("pt", "PORTUGUESE");
/* 133 */     this.hashLanguage.put("ro", "ROMANIAN");
/* 134 */     this.hashLanguage.put("ru", "RUSSIAN");
/* 135 */     this.hashLanguage.put("sr", "SERBIAN");
/* 136 */     this.hashLanguage.put("sk", "SLOVAK");
/* 137 */     this.hashLanguage.put("sl", "SLOVENIAN");
/* 138 */     this.hashLanguage.put("es", "SPANISH");
/* 139 */     this.hashLanguage.put("sw", "SWAHILI");
/* 140 */     this.hashLanguage.put("sv", "SWEDISH");
/* 141 */     this.hashLanguage.put("ta", "TAMIL");
/* 142 */     this.hashLanguage.put("te", "TELUGU");
/* 143 */     this.hashLanguage.put("th", "THAI");
/* 144 */     this.hashLanguage.put("tr", "TURKISH");
/* 145 */     this.hashLanguage.put("uk", "UKRAINIAN");
/* 146 */     this.hashLanguage.put("ur", "URDU");
/* 147 */     this.hashLanguage.put("vi", "VIETNAMESE");
/* 148 */     this.hashLanguage.put("cy", "WELSH");
/* 149 */     this.hashLanguage.put("yi", "YIDDISH");
/* 150 */     this.hashLanguage.put("af", "AFRIKAANS");
/* 151 */     this.hashLanguage.put("sq", "ALBANIAN");
/* 152 */     this.hashLanguage.put("ar", "ARABIC");
/* 153 */     this.hashLanguage.put("hy", "ARMENIAN");
/* 154 */     this.hashLanguage.put("az", "AZERBAIJANI");
/* 155 */     this.hashLanguage.put("eu", "BASQUE");
/* 156 */     this.hashLanguage.put("be", "BELARUSIAN");
/* 157 */     this.hashLanguage.put("bn", "BENGALI");
/* 158 */     this.hashLanguage.put("bg", "BULGARIAN");
/* 159 */     this.hashLanguage.put("ca", "CATALAN");
/* 160 */     this.hashLanguage.put("zh-CN", "CHINESE_SIMPLIFIED");
/* 161 */     this.hashLanguage.put("zh-TW", "CHINESE_TRADITIONAL");
/* 162 */     this.hashLanguage.put("hr", "CROATIAN");
/* 163 */     this.hashLanguage.put("cs", "CZECH");
/* 164 */     this.hashLanguage.put("da", "DANISH");
/* 165 */     this.hashLanguage.put("nl", "DUTCH");
/* 166 */     this.hashLanguage.put("et", "ESTONIAN");
/* 167 */     this.hashLanguage.put("tl", "FILIPINO");
/* 168 */     this.hashLanguage.put("fi", "FINNISH");
/* 169 */     this.hashLanguage.put("fr", "FRENCH");
/* 170 */     this.hashLanguage.put("gl", "GALICIAN");
/* 171 */     this.hashLanguage.put("ka", "GEORGIAN");
/* 172 */     this.hashLanguage.put("de", "GERMAN");
/* 173 */     this.hashLanguage.put("el", "GREEK");
/* 174 */     this.hashLanguage.put("gu", "GUJARATI");
/* 175 */     this.hashLanguage.put("ht", "HAITIAN_CREOLE");
/* 176 */     this.hashLanguage.put("iw", "HEBREW");
/* 177 */     this.hashLanguage.put("hi", "HINDI");
/* 178 */     this.hashLanguage.put("hu", "HUNGARIAN");
/* 179 */     this.hashLanguage.put("is", "ICELANDIC");
/* 180 */     this.hashLanguage.put("id", "INDONESIAN");
/* 181 */     this.hashLanguage.put("ga", "IRISH");
/* 182 */     this.hashLanguage.put("it", "ITALIAN");
/* 183 */     this.hashLanguage.put("ja", "JAPANESE");
/* 184 */     this.hashLanguage.put("kn", "KANNADA");
/* 185 */     this.hashLanguage.put("ko", "KOREAN");
/* 186 */     this.hashLanguage.put("la", "LATIN");
/* 187 */     this.hashLanguage.put("lv", "LATVIAN");
/* 188 */     this.hashLanguage.put("lt", "LITHUANIAN");
/* 189 */     this.hashLanguage.put("mk", "MACEDONIAN");
/* 190 */     this.hashLanguage.put("ms", "MALAY");
/* 191 */     this.hashLanguage.put("mt", "MALTESE");
/* 192 */     this.hashLanguage.put("no", "NORWEGIAN");
/* 193 */     this.hashLanguage.put("fa", "PERSIAN");
/* 194 */     this.hashLanguage.put("pl", "POLISH");
/* 195 */     this.hashLanguage.put("pt", "PORTUGUESE");
/* 196 */     this.hashLanguage.put("ro", "ROMANIAN");
/* 197 */     this.hashLanguage.put("ru", "RUSSIAN");
/* 198 */     this.hashLanguage.put("sr", "SERBIAN");
/* 199 */     this.hashLanguage.put("sk", "SLOVAK");
/* 200 */     this.hashLanguage.put("sl", "SLOVENIAN");
/* 201 */     this.hashLanguage.put("es", "SPANISH");
/* 202 */     this.hashLanguage.put("sw", "SWAHILI");
/* 203 */     this.hashLanguage.put("sv", "SWEDISH");
/* 204 */     this.hashLanguage.put("ta", "TAMIL");
/* 205 */     this.hashLanguage.put("te", "TELUGU");
/* 206 */     this.hashLanguage.put("th", "THAI");
/* 207 */     this.hashLanguage.put("tr", "TURKISH");
/* 208 */     this.hashLanguage.put("uk", "UKRAINIAN");
/* 209 */     this.hashLanguage.put("ur", "URDU");
/* 210 */     this.hashLanguage.put("vi", "VIETNAMESE");
/* 211 */     this.hashLanguage.put("cy", "WELSH");
/* 212 */     this.hashLanguage.put("yi", "YIDDISH");
/*     */   }
/*     */   
/*     */   public String getNameLanguage(String prefixLanguage) {
/* 216 */     return (String)this.hashLanguage.get(prefixLanguage);
/*     */   }
/*     */   
/*     */   public String getNameLanguage(String prefixLanguage, String outputLanguage)
/*     */   {
/* 221 */     Translator translate = Translator.getInstance();
/* 222 */     return translate.translate((String)this.hashLanguage.get(prefixLanguage), prefixLanguage, outputLanguage);
/*     */   }
/*     */ }


/* Location:              C:\Users\Cheese\Downloads\Google Translate.jar!\com\gtranslate\Language.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */