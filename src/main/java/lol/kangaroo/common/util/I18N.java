package lol.kangaroo.common.util;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class I18N {
	
	private Map<Locale, ResourceBundle> messages = new HashMap<>();
	
	public I18N(Locale[] supportedLanguages, File dataFolder, URL jarFile) {
		try {
			URL[] urls = {dataFolder.toURI().toURL()};
			ClassLoader loader = new URLClassLoader(urls);
			URL[] classUrls = {jarFile};
			ClassLoader cloader = new URLClassLoader(classUrls);
			for(int i = 0; i < supportedLanguages.length; i++) {
				Locale l = supportedLanguages[i];
				File possFile = new File(dataFolder, "kmessages_"+l.getLanguage()+"_"+l.getCountry()+".properties");
				if(possFile.exists())
					messages.put(l, ResourceBundle.getBundle("kmessages", l, loader));
				else
					messages.put(l, ResourceBundle.getBundle("kmessages", l, cloader));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Locale getLocale(String languageCode) {
		String[] lc = languageCode.split("_");
		return new Locale(lc[0], lc[1]);
	}
	
	public String getLocalizedMessage(String languageCode, String messageKey) {
		Locale l = getLocale(languageCode);
		return messages.get(l).getString(messageKey);
	}
	
	public String getLocalizedMessage(Locale language, String messageKey) {
		return messages.get(language).getString(messageKey);
	}

}
