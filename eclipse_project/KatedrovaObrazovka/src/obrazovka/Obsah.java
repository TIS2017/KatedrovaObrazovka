package obrazovka;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.ini4j.Ini;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Obsah {
	
	public static final String INI_NAZOV = "obsah.ini";
	public static final String INI_FORMAT_DATUM_CAS = "dd.MM.yyyy,HH:mm";	
	public static final String INI_KATEGORIA_OBSAH = "Obsah";	
	public static final String INI_KLUC_CAS_ZACIATOK = "CasZaciatok";
	public static final String INI_KLUC_CAS_KONIEC = "CasKoniec";
	public static final String INI_KLUC_PRIORITNY = "Prioritny";
	public static final String INI_KLUC_TRVANIE_ZOBRAZOVANIA = "TrvanieZobrazovania";
	public static final String INI_KLUC_ZOBRAZ_DOLNY_PANEL = "ZobrazDolnyPanel";
	public static final String INI_KLUC_ZOBRAZ_HORNY_PANEL = "ZobrazHornyPanel";
	public static final String INI_KLUC_TYP = "Typ";
	
	private int id;	
	private LocalDateTime casZaciatok;
	private LocalDateTime casKoniec;
	private boolean prioritny;	
	private double trvanieZobrazovania;	
	private boolean zobrazDolnyPanel;
	private boolean zobrazHornyPanel;
	
	public int ziskajId() {
		return id;
	}
	
	public LocalDateTime ziskajCasZaciatok() {
		return casZaciatok;
	}

	public LocalDateTime ziskajCasKoniec() {
		return casKoniec;
	}

	public boolean jePrioritny() {
		return prioritny;
	}

	public double ziskajTrvanieZobrazovania() {
		return trvanieZobrazovania;
	}

	public boolean ziskajZobrazDolnyPanel() {
		return zobrazDolnyPanel;
	}

	public boolean ziskajZobrazHornyPanel() {
		return zobrazHornyPanel;
	}

	public Obsah(int mojeId, Ini mojKonfiguracnySubor) {
		id = mojeId;		
		casZaciatok = parsujDatumCas(mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH, INI_KLUC_CAS_ZACIATOK));
		casKoniec = parsujDatumCas(mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH, INI_KLUC_CAS_KONIEC));
		prioritny = mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH, INI_KLUC_PRIORITNY, boolean.class);
		trvanieZobrazovania = parsujCas(mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH, INI_KLUC_TRVANIE_ZOBRAZOVANIA));
		zobrazDolnyPanel = mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH, INI_KLUC_ZOBRAZ_DOLNY_PANEL, boolean.class);
		zobrazHornyPanel = mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH, INI_KLUC_ZOBRAZ_HORNY_PANEL, boolean.class);
	}
	
	public LocalDateTime parsujDatumCas(String s)
	{
		if(s == null)
		{
			return null;
		}
		
		DateTimeFormatter DatumCasFormatter = DateTimeFormatter.ofPattern(INI_FORMAT_DATUM_CAS);	
		
		return LocalDateTime.parse(s, DatumCasFormatter);
	}
	
	public double parsujCas(String s)
	{
		if(s == null)
		{
			return 0.0;
		}
		
		final String Splitnute[] = s.split(":");
		float vysl = Integer.parseInt(Splitnute[0]) * 60; // Minuty		
		
		vysl += Integer.parseInt(Splitnute[1]); // Sekundy		
		
		if(Splitnute.length == 3) 
		{
			vysl += Integer.parseInt(Splitnute[2]) / 100.0; // Stotiny
		}
		
		return vysl;
	}
	
	public boolean jeZastaraly()
	{
		if(casKoniec == null)
		{
			return false;
		}
		
		return casKoniec.isBefore(LocalDateTime.now());
	}
	
	public boolean mozeBytPrehrany()
	{
		boolean zaciatokOk = true;
		boolean koniecOk = true;
		
		if(casZaciatok != null)
		{
			zaciatokOk = casZaciatok.isBefore(LocalDateTime.now());
		}
		if(casKoniec != null)
		{
			koniecOk = casKoniec.isAfter(LocalDateTime.now());
		}
		
		return zaciatokOk && koniecOk;
	}
	
	public double casDoKoncaCasovehoObmedzenia()
	{
		ZoneId zoneId = ZoneId.systemDefault();
		return casKoniec.atZone(zoneId).toEpochSecond() - LocalDateTime.now(zoneId).atZone(zoneId).toEpochSecond();	
	}
	
	public boolean spustiCasovacUkoncenia() {
		final double trvanie = jePrioritny() ? casDoKoncaCasovehoObmedzenia() * 1000 : trvanieZobrazovania * 1000; // sec to milis
		
		if(trvanie > 0) {		
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(trvanie), new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							skry();
						}
					}));	
			timeline.play();	
			return true;
		}
		else {		
			return false;
		}
	}
	
	public void zobraz() {
		if(spustiCasovacUkoncenia()) {
			if(zobrazHornyPanel)
			{
				Main.spravca.hornyPanel.zobraz();
			}
			else
			{
				Main.spravca.hornyPanel.skry();
			}
			if(zobrazDolnyPanel)
			{
				Main.spravca.dolnyPanel.zobraz();
			}
			else
			{
				Main.spravca.dolnyPanel.skry();
			}
			zobrazeny();
		}
		else {
			skry();
		}
	}
	
	protected void zobrazeny() { }	
	
	public void skry() {
		skryty();
		Main.spravca.obsahSkoncil();
	}
	
	protected void skryty() { }
	
	public void vycisti() { }
}
