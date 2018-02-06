package obrazovka;

import java.io.IOException;

import org.ini4j.Ini;

public class Obsah_Aplikacia extends Obsah {
	
	public static final String INI_KATEGORIA_OBSAH_APLIKACIA = INI_KATEGORIA_OBSAH + ".Aplikacia";	
	public static final String INI_HODNOTA_TYP_APLIKACIA = "Aplikacia";	
	public static final String INI_KLUC_COMMAND_LINE = "CommandLine";
	
	private String commandLine;
	Runtime runTime;
	Process process;
	
	public Obsah_Aplikacia(int mojeId, Ini mojKonfiguracnySubor) {
		super(mojeId, mojKonfiguracnySubor);		
		
		commandLine = mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH_APLIKACIA, INI_KLUC_COMMAND_LINE);		
		runTime = Runtime.getRuntime();
	}
	
	protected void zobrazeny() {
		String cesta = Nastavenia.ZLOZKA_OBSAH + Nastavenia.SEPARATOR + Integer.toString(ziskajId()) + Nastavenia.SEPARATOR + commandLine;

		try {
			process = runTime.exec(cesta);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	protected void skryty() {	
		process.destroy();
	}
}
