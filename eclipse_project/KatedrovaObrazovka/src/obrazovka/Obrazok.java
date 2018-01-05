package obrazovka;

import org.ini4j.Ini;

public class Obrazok extends Obsah {
	
	private static final String konfigKategoriaObrazok = konfigKategoria + ".Obrazok";
	
	public static final String klucSubor = "Subor";
	private String subor;
	
	public Obrazok(Ini mojKonfiguracnySubor)
	{
		super(mojKonfiguracnySubor);
		
		subor = mojKonfiguracnySubor.get(konfigKategoriaObrazok, klucSubor);	
		
		System.out.println(subor);
		
	}
}
