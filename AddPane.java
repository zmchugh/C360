import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.control.*;
public class AddPane extends GridPane{

    private ArrayList<VaccineEntry> list;
    private int COL_SIZE = 100;
    private TextField date, id, lastName, firstName, vType, location;
    public AddPane(ArrayList<VaccineEntry> list)
    {
        //spacing setup
        this.getColumnConstraints().add(new ColumnConstraints(COL_SIZE));
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10,10,10,10));
        //pass data
        this.list = list;
        //create components
        Label l1 = new Label("\tDate:");
        Label l2 = new Label("\tID:");
        Label l3 = new Label("\tLast Name:");
        Label l4 = new Label("\tFirst Name:");
        Label l5 = new Label("\tVaccine Type:");
        Label l6 = new Label("\tLocation:");
        date = new TextField();
        id = new TextField();
        lastName = new TextField();
        firstName = new TextField();
        vType = new TextField();
        location = new TextField();
        //add components
        this.add(l1,0,0);
        this.add(date, 1, 0);
        this.add(l2, 0, 1);
        this.add(id, 1, 1);
        this.add(l3, 0, 2);
        this.add(lastName, 1, 2);
        this.add(l4, 0, 3);
        this.add(firstName, 1, 3);
        this.add(l5, 0, 4);
        this.add(vType, 1, 4);
        this.add(l6, 0, 5);
        this.add(location, 1, 5);

        Button submit = new Button("Submit");
        submit.setPrefWidth(160);
        submit.setOnAction(new ButtonHandler());
        this.add(submit, 1, 6);
    }

    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            //get data from labels and create object -> add to list
            VaccineEntry newEntry = new VaccineEntry(id.getText(), lastName.getText(),
            firstName.getText(), vType.getText(), date.getText(), location.getText());
            
            list.add(newEntry);
        }
    }




}
