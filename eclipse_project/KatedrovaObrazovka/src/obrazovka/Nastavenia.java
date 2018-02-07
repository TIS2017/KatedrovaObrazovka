package obrazovka;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Nastavenia {
	public static String ZLOZKA_OBSAH;
	public static String ZLOZKA_ARCHIV;
	public static String SEPARATOR;

	public static String HORNY_PANEL_SUBOR;
	public static String DOLNY_PANEL_SUBOR;

	public static String DOLNY_PANEL_SEPARATOR;
	public static float DOLNY_PANEL_RYCHLOST;
	public static int DOLNY_PANEL_FONT_VELKOST;
	public static Paint DOLNY_PANEL_FONT_FARBA;
	public static int DOLNY_PANEL_TIMELINE_AKTUALIZACIA_MS;
	
	public static String NAZOV_APLIKACIE;
	public static int MINIMALIZOVANA_VELKOST;
	public static boolean CELA_OBRAZOVKA;
	
	public static String FARBA_POZADIA;
	
	public static void nacitaj() {
		final String IniSubor = "nastavenia.ini";
	
		try {
			ZLOZKA_OBSAH = new Ini(new File(IniSubor)).get("Nastavenia", "ZlozkaObsah");
			ZLOZKA_ARCHIV = new Ini(new File(IniSubor)).get("Nastavenia", "ZlozkaArchiv");
			SEPARATOR = File.separator;
			
			HORNY_PANEL_SUBOR = new Ini(new File(IniSubor)).get("Nastavenia", "HornyPanelSubor");
			DOLNY_PANEL_SUBOR = new Ini(new File(IniSubor)).get("Nastavenia", "DolnyPanelSubor");

			DOLNY_PANEL_SEPARATOR = "  " + new Ini(new File(IniSubor)).get("Nastavenia", "DolnyPanelSeparator") + "  ";
			DOLNY_PANEL_RYCHLOST = new Ini(new File(IniSubor)).get("Nastavenia", "DolnyPanelRychlost", float.class);
			DOLNY_PANEL_FONT_VELKOST = new Ini(new File(IniSubor)).get("Nastavenia", "DolnyPanelFontVelkost", int.class);
			DOLNY_PANEL_FONT_FARBA = Color.web(new Ini(new File(IniSubor)).get("Nastavenia", "DolnyPanelFontFarba"));
			DOLNY_PANEL_TIMELINE_AKTUALIZACIA_MS = new Ini(new File(IniSubor)).get("Nastavenia", "DolnyPanelTimelineAktualizaciaMs", int.class);
			
			NAZOV_APLIKACIE = "Katedrova obrazovka";
			MINIMALIZOVANA_VELKOST = new Ini(new File(IniSubor)).get("Nastavenia", "MinimalizovanaVelkost", int.class);
			CELA_OBRAZOVKA = new Ini(new File(IniSubor)).get("Nastavenia", "CelaObrazovka", boolean.class);
			
			FARBA_POZADIA = new Ini(new File(IniSubor)).get("Nastavenia", "FarbaPozadia");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
