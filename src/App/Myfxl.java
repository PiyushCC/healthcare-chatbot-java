package App;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class Myfxl {
	private Pane view;
	
	public Pane getPane(String fname) {
		try {
			URL furl =getClass().getResource(fname);
			
			if(furl == null) {
				throw new java.io.FileNotFoundException("FXML can't be found");
			}
			
			view = new FXMLLoader().load(furl);
		}
		
		catch(Exception e) {
			System.out.println("No page" + fname + "plz check");
		}
		
		return view;
	}
}
