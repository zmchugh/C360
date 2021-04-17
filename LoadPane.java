import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoadPane extends VBox{
	private VaccineList list;
	
	private TextField fileField;
	private Label msg;
	private VaccineTable table;
	
	public LoadPane(VaccineList list) {
		this.list = list;
		
     
        this.setPadding(new Insets(10,10,10,10));
        
        HBox fileLoad = new HBox();
        
        msg = new Label("");
        fileField = new TextField("Enter file name");
        //pass data
        Button load = new Button("Load from file");
        load.setPrefWidth(160);
   
        fileLoad.getChildren().addAll(fileField,load,msg);
        
        table = new VaccineTable(list.getVaccineList());
        
        this.getChildren().addAll(fileLoad,table);
		
		
	}
	
	public void update() {
		table.update();
	}
	
}
