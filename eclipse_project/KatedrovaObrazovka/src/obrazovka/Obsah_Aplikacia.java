package obrazovka;

import org.ini4j.Ini;

public class Obsah_Aplikacia extends Obsah {
	
	public static final String INI_KATEGORIA_OBSAH_APLIKACIA = INI_KATEGORIA_OBSAH + ".Aplikacia";	
	public static final String INI_HODNOTA_TYP_APLIKACIA = "Aplikacia";	
	public static final String INI_KLUC_COMMAND_LINE = "CommandLine";
	
	public Obsah_Aplikacia(int mojeId, Ini mojKonfiguracnySubor) {
		super(mojeId, mojKonfiguracnySubor);		
	}
	
	protected void zobrazeny() {

	}
	
	protected void skryty() {	

	}
}
