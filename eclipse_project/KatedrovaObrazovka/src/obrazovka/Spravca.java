package obrazovka;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Spravca {
	
	List<Obsah> obsah = new ArrayList<Obsah>();
	
	int aktualnyObsah = 0;
	
	public HornyPanel hornyPanel = new HornyPanel();
	
	public DolnyPanel dolnyPanel = new DolnyPanel();

	public void nacitajVsetokObsah()
	{
		List<String> podzlozkyObsahu = vsetkyPodzlozky(Nastavenia.ZLOZKA_OBSAH);
		obsah.clear();
		
		for(String s : podzlozkyObsahu)
		{
			try {
				int idObsahu = Integer.parseInt(s);		
				
				Obsah novy = CitacObsahu.nacitajObsah(idObsahu);
				obsah.add(novy);
				
				if(novy.jePrioritny())
				{
					aktualnyObsah = obsah.size() - 1;
				}
			} catch (NumberFormatException e) {
				System.out.println("Najdena neplatna zlozka obsahu: " + s);
			}	
		}
	}
	
	public List<String> vsetkyPodzlozky(String cesta)
	{
		List<String> vysl = new ArrayList<String>();		
		File folder = new File(cesta);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isDirectory()) {
		        vysl.add(file.getName());
		    }
		}
		
		return vysl;
	}
	
	public void obsahSkoncil()
	{
		zobrazNasledujuciObsah();
	}
	
	public void zobrazAktualnyObsah()
	{
		if(obsah.size() > aktualnyObsah)
		{
			Obsah aktualny = obsah.get(aktualnyObsah);
			
			if(skontrolujCasoveObmedzenie(aktualny))
			{
				if(!obsah.isEmpty())
				{
					aktualny.zobraz();
				}
			}
			else
			{
				zobrazNasledujuciObsah();
			}
		}
	}
	
	public void zobrazNasledujuciObsah()
	{
		if(obsah.size() > aktualnyObsah)
		{
			aktualnyObsah += 1;
			aktualnyObsah %= obsah.size();
			zobrazAktualnyObsah();
		}
	}
	
	public boolean skontrolujCasoveObmedzenie(Obsah obsahNaKontrolu)
	{
		if(obsahNaKontrolu.jeZastaraly())
		{
			presunObsahDoArchivu(obsahNaKontrolu);
			
			if(!obsah.isEmpty())
			{
				aktualnyObsah %= obsah.size();
			}
			return false;
		}

		return obsahNaKontrolu.mozeBytPrehrany();
	}
	
	public void presunObsahDoArchivu(Obsah obsahNaPresunutie)
	{
		Path zdroj = new File(Nastavenia.ZLOZKA_OBSAH + Nastavenia.SEPARATOR + Integer.toString(obsahNaPresunutie.ziskajId())).toPath();
		Path ciel = new File(Nastavenia.ZLOZKA_ARCHIV + Nastavenia.SEPARATOR + Integer.toString(obsahNaPresunutie.ziskajId())).toPath();
		
		obsahNaPresunutie.vycisti();
		
		try {
			Files.move(zdroj, ciel, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		obsah.remove(obsahNaPresunutie);
	}
}
