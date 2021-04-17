import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class LoadPane extends VBox{
	private VaccineList list;
	
	private TextField fileField;
	private Label msg;
	private VaccineTable table;
	
	public LoadPane(VaccineList list) {
		this.list = list;
     
        this.setPadding(new Insets(10,10,10,10));
        
        HBox fileLoad = new HBox();
        
        this.setSpacing(20);
        
        msg = new Label("");
        fileField = new TextField("Enter file name");
        //pass data
        Button load = new Button("Load from file");
        load.setPrefWidth(160);
        
        load.setOnAction(new ButtonHandler());
   
        fileLoad.getChildren().addAll(load,msg);
        
        table = new VaccineTable(list);
        
        this.getChildren().addAll(fileLoad,table);
		
		
	}
	
	public void update() {
		table.update();
	}


	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			
			FileChooser fileChooser = new FileChooser();
	  		fileChooser.setTitle("Open Resource File");
	  		fileChooser.getExtensionFilters().add(new ExtensionFilter("Comma Seperated Values", "*.csv"));
	  		File f = fileChooser.showOpenDialog(getScene().getWindow());
	  		
	  		
			msg.setText("");

			try {
				
				FileReader fr = new FileReader(f);
				Scanner scan = new Scanner(fr);
				scan.nextLine(); //read label line
				while(scan.hasNext()) {
					String line = scan.nextLine();
					String split[] = line.split(",");

					if(split.length != 6) {
						//wrong number of fields
						msg.setText("Invalid input format!");
						update();
					}
					else {
						VaccineEntry ve = new VaccineEntry(split[0], split[1], split[2], split[3], split[4], split[5]);
						list.add(ve);
					}
				}

				scan.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch(NullPointerException exc) {
				exc.printStackTrace();
			}
			update();
		}

	}

}