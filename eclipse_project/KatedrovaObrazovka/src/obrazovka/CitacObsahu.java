package obrazovka;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;

public class CitacObsahu {

	public static Obsah nacitajObsah(int id)
	{
		String cesta = Nastavenia.zlozkaObsahu + Nastavenia.separator + Integer.toString(id) + Nastavenia.separator + Nastavenia.konfiguracnySuborObsahu;
		Ini konfigObsahu;
		
		try {
			konfigObsahu = new Ini(new File(cesta));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
		String typ = konfigObsahu.get(Obsah.konfigKategoria, Obsah.klucTyp).toLowerCase();
		
		Obsah novyObsah = null;
		
		if(typ.equals(Obsah.klucTypObrazok))
		{
			novyObsah = new Obrazok(konfigObsahu);
		}
		else if(typ.equals(Obsah.klucTypVideo))
		{
			novyObsah = new Video(konfigObsahu);
		}
		
		return novyObsah;
	}
}
