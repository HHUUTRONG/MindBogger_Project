package maingame;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleLanguage {
	Locale current;
	ResourceBundle bundle;
	
	public void Vietnamese() {
		current = new Locale("vi", "VN");
		bundle= ResourceBundle.getBundle("Language", current);
	}
	
	public void English() {
		current = new Locale("en", "US");
		bundle= ResourceBundle.getBundle("Language", current);
	}
	
	public void German() {
		current = new Locale("de", "DEU");
		bundle= ResourceBundle.getBundle("Language", current);
	}
}
