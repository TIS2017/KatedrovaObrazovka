package obrazovka;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Spravca {
	
	List<Obsah> obsah = new ArrayList<Obsah>();

	public void nacitajVsetokObsah()
	{
		List<String> podzlozkyObsahu = vsetkyPodzlozky(Nastavenia.zlozkaObsahu);
		
		for(String s : podzlozkyObsahu)
		{
			int idObsahu = Integer.parseInt(s);		
			obsah.add(CitacObsahu.nacitajObsah(idObsahu));
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
	
	public void zacniZobrazovanieObsahu()
	{
		
	}
}
