package obrazovka;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class DolnyPanel {
	private Text text;
	private ObjectProperty<Font> fontTracking = new SimpleObjectProperty<Font>(Font.getDefault());
	
	public DolnyPanel() {
		String spravy = nacitajSpravy();
		
		text = new Text(spravy);
		text.setFill(Nastavenia.DOLNY_PANEL_FONT_FARBA);
		text.fontProperty().bind(fontTracking);
		aktualizujVelkost();
	    
	    Main.root.widthProperty().addListener(new ChangeListener<Number>() {
	        @Override 
	        public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
	        	aktualizujVelkost();
	        }
	    });
	}
	
	public String nacitajSpravy() {
		String spravy = "";
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Nastavenia.DOLNY_PANEL_SUBOR), StandardCharsets.UTF_8))) {
			StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line.trim());
		        sb.append(Nastavenia.DOLNY_PANEL_SEPARATOR);
		        line = br.readLine();
		    }
		    spravy = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return spravy;
	}
	
	public void aktualizujVelkost() {
		fontTracking.set(Font.font((Main.root.getWidth() / Main.root.getHeight()) * Nastavenia.DOLNY_PANEL_FONT_VELKOST));		
		spustiAnimaciu();
	}
	
	public void spustiAnimaciu() {
	    Timeline timeline = new Timeline(
				new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						text.setTranslateX(text.getTranslateX() - Nastavenia.DOLNY_PANEL_RYCHLOST);
						if(text.getTranslateX() < -1.0 * text.getLayoutBounds().getWidth())
						{
							text.setTranslateX(text.getLayoutBounds().getWidth());
						}
					}
				}));

	    timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.play();
	}
	
	public void zobraz() {
		Main.root.setBottom(text);		
	}
	
	public void skry() {
		Main.root.setBottom(null);
	}
}
