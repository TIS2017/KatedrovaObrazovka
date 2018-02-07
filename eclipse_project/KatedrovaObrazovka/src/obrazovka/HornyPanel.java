package obrazovka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HornyPanel {
	ImageView imageView;

	public HornyPanel() {
		Image image = null;
		try {
			image = new Image(new FileInputStream(new File(Nastavenia.HORNY_PANEL_SUBOR)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		imageView = new ImageView();
		imageView.setPreserveRatio(true);
		imageView.fitHeightProperty().bind(Main.primaryStage.heightProperty());
		imageView.fitWidthProperty().bind(Main.primaryStage.widthProperty());
		imageView.setSmooth(true);
		imageView.setCache(true);
		imageView.setImage(image);
	}

	public void zobraz() {
		Main.root.setTop(imageView);
	}

	public void skry() {
		Main.root.setTop(null);
	}

}
