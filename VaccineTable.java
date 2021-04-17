import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class VaccineTable extends ScrollPane{
	private VaccineList list;
	private GridPane table;
	public VaccineTable(VaccineList list) {
		this.list = list;


		table = new GridPane();
		table.setPadding(new Insets(10,10,10,10));
		table.setHgap(20);
		table.setVgap(20);
		
		
		update();

		this.setContent(table);


	}


	public void update() {
		table.getChildren().clear();
		Label id = new Label("ID");
		Label last = new Label("Last Name");
		Label first = new Label("First Name");
		Label type = new Label("Vaccine Type");
		Label date = new Label("Vaccine Date");
		Label loc = new Label("Vaccine Location");
		table.add(id, 0, 0);
		table.add(last, 1, 0);
		table.add(first, 2, 0);
		table.add(type, 3, 0);
		table.add(date, 4, 0);
		table.add(loc, 5, 0);
		for(int i = 0; i < list.getVaccineList().size(); i++) {
			VaccineEntry e = list.getVaccineList().get(i);
			Label idl = new Label(e.getId());
			Label lastl = new Label(e.getLastName());
			Label firstl = new Label(e.getFirstName());
			Label typel = new Label(e.getType());
			Label datel = new Label(e.getDate());
			Label locl = new Label(e.getLocation());
			table.add(idl, 0, i+1);
			table.add(lastl, 1, i+1);
			table.add(firstl, 2, i+1);
			table.add(typel, 3, i+1);
			table.add(datel, 4, i+1);
			table.add(locl, 5, i+1);
		}
	}

}