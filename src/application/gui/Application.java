package application.gui;

import application.config.AppConfig;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application{
	
	// TODO: remove all syso
	// TODO write tests
	// TODO: zoom
	// TODO: disable button while drawing
	
	private String[] arguments;
	private Stage primaryStage;
	private AppConfig config;
	private HBox root; //change to the base node
	
	
	@Override
	public void start(Stage primaryStage){
		loadConfiguration();
		setPrimaryStage(primaryStage);
		loadApplicationWindow();
	}
	
	private void loadConfiguration(){
		config = AppConfig.instance;
	}
	
	private void setPrimaryStage(Stage primaryStage){
		this.primaryStage = primaryStage;
	}
	
	private void loadApplicationWindow(){
		primaryStage.setTitle(config.applicationTitle);
		primaryStage.setResizable(false);
		
		try{
			root = FXMLLoader.load(getClass().getResource("model/ApplicationModel.fxml"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root, config.windowWidth, config.windowHeight);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void startApplication(){
		launch(arguments);
	}
	
	public void setArguments(String... args){
		this.arguments = args;
	}
}
