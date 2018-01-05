package obrazovka;

import java.io.File;

import org.ini4j.Ini;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import manazer_obsahu.ManazerObsahu;

public class Aplikacia extends Application {
	
	/**
	 * Root java fx element.
	 */
	public static BorderPane root;
	
	/**
	 * Application scale.
	 */
	public final static int WINDOW_SIZE = 900;
	
	public final static String TITLE = "Katedrova obrazovka";
	
	Spravca spravca;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle(TITLE);
		root = new BorderPane();

		primaryStage.setScene(new Scene(root, WINDOW_SIZE, WINDOW_SIZE));
		primaryStage.show();
		
		spravca = new Spravca();		
		spravca.nacitajVsetokObsah();	
	}
	

}
