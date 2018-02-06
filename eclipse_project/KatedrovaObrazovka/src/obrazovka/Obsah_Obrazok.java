package obrazovka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.Ini;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Obsah_Obrazok extends Obsah {
	
	public static final String INI_KATEGORIA_OBSAH_OBRAZOK = INI_KATEGORIA_OBSAH + ".Obrazok";	
	public static final String INI_HODNOTA_TYP_OBRAZOK = "Obrazok";	
	public static final String INI_KLUC_SUBOR = "Subor";
	
	private String subor;	
	private ImageView imageView;
	private FileInputStream imageFileInputStream;
	
	public Obsah_Obrazok(int mojeId, Ini mojKonfiguracnySubor) {
		super(mojeId, mojKonfiguracnySubor);
		
		subor = mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH_OBRAZOK, INI_KLUC_SUBOR);	
		String cesta = Nastavenia.ZLOZKA_OBSAH + Nastavenia.SEPARATOR + Integer.toString(ziskajId()) + Nastavenia.SEPARATOR + subor;
		
		try {
			imageFileInputStream = new FileInputStream(new File(cesta));
			Image image = new Image(imageFileInputStream);
			imageView = new ImageView();	
			imageView.setImage(image);
			imageView.setPreserveRatio(true);
			imageView.fitHeightProperty().bind(Main.primaryStage.heightProperty());
			imageView.fitWidthProperty().bind(Main.primaryStage.widthProperty());
			imageView.setSmooth(true);
			imageView.setCache(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	protected void zobrazeny() {
		Main.root.setCenter(imageView);
	}
	
	protected void skryty() {	
		Main.root.setCenter(null);
	}
	
	public void vycisti() {
		try {
			imageFileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
