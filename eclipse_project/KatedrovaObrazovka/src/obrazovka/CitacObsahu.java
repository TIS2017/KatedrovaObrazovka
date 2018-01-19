package obrazovka;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;

public class CitacObsahu {

	public static Obsah nacitajObsah(int id)
	{
		final String cesta = Nastavenia.ZLOZKA_OBSAH + Nastavenia.SEPARATOR + Integer.toString(id) + Nastavenia.SEPARATOR + Obsah.INI_NAZOV;	
		Ini konfigObsahu;
		
		try {
			konfigObsahu = new Ini(new File(cesta));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
		
		final String typ = konfigObsahu.get(Obsah.INI_KATEGORIA_OBSAH, Obsah.INI_KLUC_TYP);
		Obsah novyObsah = null;
		
		if(typ.equalsIgnoreCase(Obsah_Obrazok.INI_HODNOTA_TYP_OBRAZOK))
		{
			novyObsah = new Obsah_Obrazok(id, konfigObsahu);
		}
		else if(typ.equalsIgnoreCase(Obsah_YouTubeVideo.INI_HODNOTA_TYP_YOUTUBE_VIDEO))
		{
			novyObsah = new Obsah_YouTubeVideo(id, konfigObsahu);
		}
		else if(typ.equalsIgnoreCase(Obsah_Aplikacia.INI_HODNOTA_TYP_APLIKACIA))
		{
			novyObsah = new Obsah_Aplikacia(id, konfigObsahu);
		}
		
		return novyObsah;
	}
}
