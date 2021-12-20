package App;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GuiControl implements Initializable {
	

    @FXML
    private ScrollPane scrollP;

    @FXML
    private VBox myVBox;

    @FXML
    private TextField tfUser;

    @FXML
    private Button btnSend;

    @FXML
    private Label lbReply;
    
    @FXML
    private Label lbInp;
    
    public MyBot b1;
    
    private String input;
    
    private String answer;
    
    private Label lbBot;
    private Label lbUser;
    Desktop dt;
    
    @FXML
    void btnSendClick(ActionEvent event) throws IOException, URISyntaxException {
    	input = tfUser.getText(); // input in string variable
    	tfUser.setText("");
    	
    	answer = b1.giveReply(input);		//reply in string variable
    	answer = answer.replace("nl","\n" );//filter the reply
    	
    	System.out.println(answer);//printing the answer just in case
    	
    	// Searching ///////////////////////////
    	
    	if(answer.equals("show hospitals")) {
    		dt.browse(new URI("https://www.google.com/search?rlz=1C1CHBF_enIN913IN913&tbs=lf:1,lf_ui:2&tbm=lcl&sxsrf=ALeKk023D5ggh0uryCBRc-Sv9aDUchi_ng:1606655283074&q=hospital+near+me&rflfq=1&num=10&sa=X&ved=2ahUKEwjR-bGr6aftAhU6wjgGHStPD20QjGp6BAgDEFM&biw=1536&bih=754#rlfi=hd:;si:;mv:[[21.049418057920985,75.85282972697752],[21.0005470367011,75.75704267863767],null,[21.02498455009173,75.8049362028076],14]"));
    		setBoxesUser();
    		return;
    	}
    	else if(answer.equals("link alz")){
    		dt.browse(new URI("https://www.nhp.gov.in/disease/neurological/alzheimer-s-disease"));
    		setBoxesUser();
    		return;
    	}
    	else if(answer.equals("gotosite")){
    		dt.browse(new URI("https://www.nhp.gov.in/disease-a-z"));
    		setBoxesUser();
    		return;
    	}
    	
    	//////////////////////////////////////////
    	
    	setLabels();
    	
    	setBoxes();
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		b1 = new MyBot();
		initDesk();
		
		answer = b1.giveReply("GIVE INTRO");
		answer = answer.replace("nl","\n" );
		setLabels();
		setBoxesBot();
	}
	
	public void setBoxes() {
		HBox myHBox = new HBox();
    	myHBox.getChildren().add(lbUser);
    	myHBox.setAlignment(Pos.BASELINE_RIGHT);
    	
    	myVBox.getChildren().add(myHBox);

		myVBox.getChildren().add(lbBot);

		myVBox.heightProperty().addListener(observable -> scrollP.setVvalue(1D));
		myVBox.setSpacing(20);
	}
	
	public void setBoxesBot() {
		HBox myHBox = new HBox();
    	//myHBox.getChildren().add(lbUser);
    	myHBox.setAlignment(Pos.BASELINE_RIGHT);
    	
    	myVBox.getChildren().add(myHBox);

		myVBox.getChildren().add(lbBot);

		myVBox.heightProperty().addListener(observable -> scrollP.setVvalue(1D));
		myVBox.setSpacing(20);
	}
	
	public void setBoxesUser() {
		HBox myHBox = new HBox();
    	myHBox.getChildren().add(lbUser);
    	myHBox.setAlignment(Pos.BASELINE_RIGHT);
    	
    	myVBox.getChildren().add(myHBox);

		//myVBox.getChildren().add(lbBot);

		myVBox.heightProperty().addListener(observable -> scrollP.setVvalue(1D));
		myVBox.setSpacing(20);
	}
	
	public void initDesk() {
		dt = Desktop.getDesktop();
	}
	
	public void setLabels() {
		lbUser = new Label(input);
    	lbUser.setMinWidth(400);
    	lbUser.setMinHeight(85);
    	lbUser.setMaxHeight(85);
    	lbUser.maxWidth(400);
    	lbUser.setPrefHeight(85);
    	lbUser.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    	
    	lbBot = new Label(answer);
    	lbBot.setMinWidth(400);
    	lbBot.setMinHeight(85);
    	lbBot.setMaxHeight(85);
    	lbBot.maxWidth(400);
    	lbBot.setPrefHeight(85);
    	lbBot.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    	
    	lbBot.setTextFill(Color.web("#FFFFFF"));
    	
    	lbUser.getStyleClass().add("labelU");
    	lbBot.getStyleClass().add("labelB");
    	lbUser.setStyle("-fx-background-color: #e600e6");
    	lbBot.setStyle("-fx-background-color: #4169E1");
	}

}
