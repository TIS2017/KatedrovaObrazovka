package obrazovka;

import org.ini4j.Ini;

public class Obsah_Obrazok extends Obsah {
	
	public static final String INI_KATEGORIA_OBSAH_OBRAZOK = INI_KATEGORIA_OBSAH + ".Obrazok";	
	public static final String INI_HODNOTA_TYP_OBRAZOK = "Obrazok";	
	public static final String INI_KLUC_SUBOR = "Subor";
	
	public Obsah_Obrazok(int mojeId, Ini mojKonfiguracnySubor)
	{
		super(mojeId, mojKonfiguracnySubor);
	}
	
	protected void zobrazeny()
	{
		
	}
	
	protected void skryty()
	{	

	}
}
