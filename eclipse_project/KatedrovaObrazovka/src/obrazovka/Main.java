package obrazovka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * 
 * @author Ondrej Hrusovsky, Simona Backovska
 *
 */
public class Main extends Application {

	public static BorderPane root;

	public static Stage primaryStage;

	public static Spravca spravca;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage newPrimaryStage) throws Exception {
		Nastavenia.nacitaj();
		// TODO Auto-generated method stub
		primaryStage = newPrimaryStage;
		primaryStage.setTitle(Nastavenia.NAZOV_APLIKACIE);
		root = new BorderPane();
		root.setStyle("-fx-background-color: " + Nastavenia.FARBA_POZADIA + ";");

		primaryStage.setScene(new Scene(root, Nastavenia.MINIMALIZOVANA_VELKOST, Nastavenia.MINIMALIZOVANA_VELKOST));
		primaryStage.setFullScreen(Nastavenia.CELA_OBRAZOVKA);
		primaryStage.show();

		spravca = new Spravca();
		spravca.nacitajVsetokObsah();
		spravca.zobrazAktualnyObsah();
	}

}
