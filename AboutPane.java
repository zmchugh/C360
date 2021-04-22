import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.*;
/**
 * AboutPane presents information about the team
 */
public class AboutPane extends GridPane {
	
	private int COL_SIZE = 150;
    /**
     * Constructor for the AboutPane creates the Pane with information
     */
	public AboutPane() {
		//spacing setup
        this.getColumnConstraints().add(new ColumnConstraints(COL_SIZE));
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10,10,10,10));
        
        // Names
        Label l0 = new Label("\tTeam Members:");
        Label l1 = new Label("\tDylan Fulop");
        Label l2 = new Label("\tGuoan Hu");
        Label l3 = new Label("\tZachary Mchugh");
        Label l4 = new Label("\tHolden Payne");
        
        this.add(l0,0,0);
        this.add(l1,0,1);
        this.add(l2, 0, 2);
        this.add(l3, 0, 3);
        this.add(l4, 0, 4);
	}
}
