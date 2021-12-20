package App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class BaseCon {

    @FXML
    private Button btnChat;

    @FXML
    private Button btnIns;
    
    @FXML
    private BorderPane bPane;
    
    @FXML
    private Button btndb;
    
    Myfxl mload = new Myfxl();
    
    Pane viewChat=mload.getPane("Botgui.fxml");;
    
    Pane view;
    
    Pane viewInfo=mload.getPane("infofx.fxml");;
    
    Pane viewData=mload.getPane("datab.fxml");;
    
    @FXML
    private Button btnExit;

    @FXML
    void chatClick(ActionEvent event) {
    	//view = mload.getPane("Botgui.fxml");
    	view = viewChat;
    	bPane.setCenter(view);
    }

    @FXML
    void insClick(ActionEvent event) {
    	//view = mload.getPane("infofx.fxml");
    	view = viewInfo;
    	bPane.setCenter(view);
    }
    
    @FXML
    void dbClick(ActionEvent event) {
    	//view = mload.getPane("datab.fxml");
    	view = viewData;
    	bPane.setCenter(view);
    }
    
    @FXML
    void exitClick(ActionEvent event) {
    	System.exit(0);
    }

}
