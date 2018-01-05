package obrazovka;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.ini4j.Ini;

public class Obsah {
	
	public static final String formatDatumCas = "dd.MM.yyyy,HH:mm";
	
	public static final String konfigKategoria = "Obsah";
	
	public static final String klucTyp = "Typ";
	public static final String klucTypObrazok = "obrazok";
	public static final String klucTypVideo = "video";
	
	public static final String klucCasZaciatok = "CasZaciatok";
	private LocalDateTime casZaciatok;
	
	public static final String klucCasKoniec = "CasKoniec";
	private LocalDateTime casKoniec;
	
	public static final String klucPrioritny = "Prioritny";
	private boolean prioritny = false;
	
	public static final String klucTrvanieZobrazovania = "TrvanieZobrazovania";
	private int trvanieZobrazovania = 10;
	
	public static final String klucZobrazDolnyPanel = "ZobrazDolnyPanel";
	private boolean zobrazDolnyPanel = false;
	
	public static final String klucZobrazHornyPanel = "ZobrazHornyPanel";
	private boolean zobrazHornyPanel = false;
	
	public LocalDateTime ziskajCasZaciatok() {
		return casZaciatok;
	}

	public LocalDateTime ziskajCasKoniec() {
		return casKoniec;
	}

	public boolean jePrioritny() {
		return prioritny;
	}

	public int ziskajTrvanieZobrazovania() {
		return trvanieZobrazovania;
	}

	public boolean ziskajZobrazDolnyPanel() {
		return zobrazDolnyPanel;
	}

	public boolean ziskajZobrazHornyPanel() {
		return zobrazHornyPanel;
	}

	public Obsah(Ini mojKonfiguracnySubor)
	{
		DateTimeFormatter DatumCasFormatter = DateTimeFormatter.ofPattern(formatDatumCas);	
		casZaciatok = LocalDateTime.parse(mojKonfiguracnySubor.get(konfigKategoria, klucCasZaciatok), DatumCasFormatter);
		casKoniec = LocalDateTime.parse(mojKonfiguracnySubor.get(konfigKategoria, klucCasKoniec), DatumCasFormatter);
		
		final String prioritnyString = mojKonfiguracnySubor.get(konfigKategoria, klucPrioritny).toLowerCase();		
		if(prioritnyString.equals(Boolean.toString(true)))
		{
			prioritny = true;
		}
		else if(prioritnyString.equals(Boolean.toString(false)))
		{
			prioritny = false;
		}
		
		final String trvanieZobrazovaniaString = mojKonfiguracnySubor.get(konfigKategoria, klucTrvanieZobrazovania);		
		trvanieZobrazovania = Integer.parseInt(trvanieZobrazovaniaString);
		
		final String zobrazDolnyPanelString = mojKonfiguracnySubor.get(konfigKategoria, klucZobrazDolnyPanel).toLowerCase();		
		if(zobrazDolnyPanelString.equals(Boolean.toString(true)))
		{
			zobrazDolnyPanel = true;
		}
		else if(zobrazDolnyPanelString.equals(Boolean.toString(false)))
		{
			zobrazDolnyPanel = false;
		}
		
		final String zobrazHornyPanelString = mojKonfiguracnySubor.get(konfigKategoria, klucZobrazHornyPanel).toLowerCase();		
		if(zobrazHornyPanelString.equals(Boolean.toString(true)))
		{
			zobrazHornyPanel = true;
		}
		else if(zobrazHornyPanelString.equals(Boolean.toString(false)))
		{
			zobrazHornyPanel = false;
		}
	}
}
