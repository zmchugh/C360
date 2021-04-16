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

	private ArrayList<VaccineEntry> list;
	private int COL_SIZE = 150;
	private TextField input;
	private Label msg;
    public SavePane(ArrayList<VaccineEntry> list)
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
				writer.write("");	// This creates/clears a file
				// This Starts off the file by listing the column names at the top.
				for(int j = 0; j < 6; j++) {
            		if(j == 0) {
            			writer.append("ID");
            			writer.append(",");
            		}if(j == 1) {
            			writer.append("Last Name");
            			writer.append(",");
            		}if(j == 2) {
            			writer.append("First Name");
            			writer.append(",");
            		}if(j == 3) {
            			writer.append("Vaccine Type");
            			writer.append(",");
            		}if(j == 4) {
            			writer.append("Vaccination Date");
            			writer.append(",");
            		}if(j == 5) {
            			writer.append("Vaccine Location");
            		}
            		
            	}
				writer.append("\n");
				// These nested loops iterate through the list and write to the file
				for(int i = 0; i < list.size(); i++) {
	            	// Writes each column
					for(int j = 0; j < 6; j++) {
	            		if(j == 0) {
	            			writer.append(list.get(i).getId());
	            			writer.append(",");
	            		}if(j == 1) {
	            			writer.append(list.get(i).getLastName());
	            			writer.append(",");
	            		}if(j == 2) {
	            			writer.append(list.get(i).getFirstName());
	            			writer.append(",");
	            		}if(j == 3) {
	            			writer.append(list.get(i).getType());
	            			writer.append(",");
	            		}if(j == 4) {
	            			writer.append(list.get(i).getDate());
	            			writer.append(",");
	            		}if(j == 5) {
	            			writer.append(list.get(i).getLocation());
	            		}
	            	}
	            	// Newline once current index has ended
	            	writer.append("\n");
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
