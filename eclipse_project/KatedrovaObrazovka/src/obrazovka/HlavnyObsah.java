package obrazovka;

import javafx.scene.layout.Pane;

public class HlavnyObsah extends Pane {
	
	void zobraz()
	{
		Obrazok o = new Obrazok();
		Video v = new Video();
		
		o.vykresli();
		v.vykresli();
	}
}
