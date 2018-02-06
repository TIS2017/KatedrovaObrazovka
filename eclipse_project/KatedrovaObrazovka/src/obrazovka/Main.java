package obrazovka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Root java fx element.
	 */
	public static BorderPane root;

	public static Stage primaryStage;

	/**
	 * Application scale.
	 */
	public final static int WINDOW_SIZE = 900;

	public final static String TITLE = "Katedrova obrazovka";

	public static Spravca spravca;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage newPrimaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage = newPrimaryStage;
		primaryStage.setTitle(TITLE);
		root = new BorderPane();
		root.setStyle("-fx-background-color: black;");

		primaryStage.setScene(new Scene(root, WINDOW_SIZE, WINDOW_SIZE));
		// primaryStage.setFullScreen(true);
		primaryStage.show();

		spravca = new Spravca();
		spravca.nacitajVsetokObsah();
		spravca.zobrazAktualnyObsah();
	}

}
