import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.*;
public class SavePane extends GridPane{

	private VaccineList list;
	private int COL_SIZE = 150;
	private TextField input;
	private Label msg;
    public SavePane(VaccineList list)
    {
    	//spacing setup
        this.getColumnConstraints().add(new ColumnConstraints(COL_SIZE));
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10,10,10,10));
        msg = new Label("");
        input = new TextField("Enter file name");
        //pass data
        this.list = list;
        Button save = new Button("Save to file");
        save.setPrefWidth(160);
        save.setOnAction(new ButtonHandler());
        this.add(input, 0, 0);
        this.add(save, 0, 1);
        this.add(msg, 0, 2);
    }
    
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
        	// Get a file name from user input
        	String fileName = "test.csv";
            fileName = input.getText();
            fileName += ".csv";
        	
            try {
				// Setup a buffered writer to write to said file name
            	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
				writer.write("ID,Last Name,First Name,Vaccine Type,Vaccination Date,Vaccine Location\n");	// This creates/clears a file		
				// Appends to a new line for every vaccineEntry
				for(int i = 0; i < list.getVaccineList().size(); i++) {
					writer.append(list.getVaccineList().get(i).toString());
	            }
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
            msg.setText("Saved Successfully");
            msg.setTextFill(Color.GREEN);

        }
    }
}
