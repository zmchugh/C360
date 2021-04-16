import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainClass extends Application
{

  	public void start(Stage primaryStage)
  	{
  		
  		ArrayList<VaccineEntry> vaccineList = new ArrayList<VaccineEntry>();  		
  		
  		StackPane root = new StackPane();
  		TabPane tabPane = new TabPane();
  		
  		
  		AboutPane aboutPane = new AboutPane();
  		
		Tab about = new Tab();
		about.setText("About");
		about.setClosable(false);
		about.setContent(aboutPane);
  		
		Pane loadPane = new LoadPane(vaccineList);
		
		Tab load = new Tab();
		load.setText("Load Data");
		load.setClosable(false);
		load.setContent(loadPane);
		
		AddPane addPane = new AddPane(vaccineList);
		
		Tab add = new Tab();
		add.setText("Add Data");
		add.setClosable(false);
		add.setContent(addPane);
		
		SavePane savePane = new SavePane(vaccineList);
		
		Tab save = new Tab();
		save.setText("Save Data");
		save.setClosable(false);
		save.setContent(savePane);
		
		Pane visualPane = new VBox();
		
		Tab visual = new Tab();
		visual.setText("Visualize Data");
		visual.setClosable(false);
		visual.setContent(visualPane);
  		
		tabPane.getSelectionModel().select(0);
		tabPane.getTabs().addAll(about, load, add, save, visual);
		
  		root.getChildren().add(tabPane);
  		
  		
    	Scene scene = new Scene(root, 1000, 800);
   		primaryStage.setTitle("Vaccination Records");
   		primaryStage.setScene(scene);
   		primaryStage.show();
  	}

  public static void main(String[] args)
  {
    launch(args);
  } 
}