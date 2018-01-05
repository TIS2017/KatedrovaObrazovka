package obrazovka;

import javafx.application.Application;
import javafx.stage.Stage;
import manazer_obsahu.ManazerObsahu;

public class Obrazovka extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
		nacitajObsah();
		vykresliObsah();
	}
	
	public void nacitajObsah()
	{
		ManazerObsahu mo = new ManazerObsahu();
		
		if(mo != null)
		{
			mo.skontrolujAktualnost();
		}
	}
	
	public void vykresliObsah()
	{
		Hlavicka h = new Hlavicka();
		DolnyPanel d = new DolnyPanel();
		
		h.vykresli();
		d.vykresli();
	}
}
