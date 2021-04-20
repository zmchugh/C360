import javafx.scene.layout.VBox;
// For vaccineList
import java.util.ArrayList;
// import all other necessary javafx classes here
// Nodes
import javafx.scene.control.Button;
// Layout
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
// Action Handling
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
// Chart
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
// for counting frequencies
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 * VisualPane visualizes data model by providing charts
 * @author Guoan Hu
 */
public class VisualPane extends VBox {
    private VaccineList list;
    protected BarChartDisplay barChart;
    /** 
     * Constructor
     */
    public VisualPane(VaccineList list) {
        this.list = list;

        this.setPadding(new Insets(10, 10, 10, 10));

        VBox viewButton = new VBox();

        Button viewByType = new Button("Visualize Data by Doses Adminisitered for each Type");
        Button viewByLocation = new Button("Visualize Data by Doses Adminisitered in each Location");

        viewByType.setPrefWidth(320);
        viewByLocation.setPrefWidth(320);

        viewByType.setAlignment(Pos.BASELINE_LEFT);
        viewByLocation.setAlignment(Pos.BASELINE_LEFT);

        viewButton.getChildren().addAll(viewByType, viewByLocation);

        viewByType.setOnAction(new typeChartHandler());
        viewByLocation.setOnAction(new locationChartHandler());

        // create bar chart
        barChart = new BarChartDisplay();
        barChart.setPrefSize(960, 960);
        this.getChildren().addAll(viewButton, barChart);
    }

    private class typeChartHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) { 
            // erase previous data
            barChart.eraseDataSeries();
            // update label
            barChart.updateChartLabel("Vaccine Type", "Doses");
            ArrayList<VaccineEntry> copy = list.getVaccineList();
            // HashMap to count number of occurences
            Map<String, Integer> hm = new HashMap<String, Integer>();
            //
            for (VaccineEntry i : copy) {
                Integer j = hm.get(i.getType());
                hm.put(i.getType(), (j == null) ? 1 : j + 1);
            }
            // displaying the occurrence of elements in the arraylist
            for (Map.Entry<String, Integer> val : hm.entrySet()) {
                barChart.updateDataSeries(val.getKey(), val.getValue());
            }
        }
    }
    
    private class locationChartHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            // erase previous data
            barChart.eraseDataSeries();
            // update label
            barChart.updateChartLabel("Location", "Doses");
            ArrayList<VaccineEntry> copy = list.getVaccineList();
            // HashMap to count number of occurences
            Map<String, Integer> hm = new HashMap<String, Integer>();
            //
            for (VaccineEntry i : copy) {
                Integer j = hm.get(i.getLocation());
                hm.put(i.getLocation(), (j == null) ? 1 : j + 1);
            }
            // displaying the occurrence of elements in the arraylist
            for (Map.Entry<String, Integer> val : hm.entrySet()) {
                barChart.updateDataSeries(val.getKey(), val.getValue());
            }
        }
    }

    private class BarChartDisplay extends GridPane {
        CategoryAxis xAxis;
        NumberAxis yAxis;
        BarChart barChart;

        BarChartDisplay() {
            xAxis = new CategoryAxis();
            xAxis.setLabel("");

            yAxis = new NumberAxis();
            yAxis.setLabel("");

            barChart = new BarChart(xAxis, yAxis);

            barChart.setBarGap(2d);
            barChart.setCategoryGap(5d);

            this.getChildren().addAll(barChart);
        }

        public void updateChartLabel(String xAxisLabel, String yAxisLabel) {
            xAxis.setLabel(xAxisLabel);
            yAxis.setLabel(yAxisLabel);
        }

        public void updateDataSeries(String basketName, int count) {
            XYChart.Series<String, Integer> dataSeries = new XYChart.Series<String, Integer>();
            dataSeries.getData().add(new XYChart.Data<String, Integer>("", count));
            dataSeries.setName(basketName);
            barChart.getData().add(dataSeries);
        }

        public void eraseDataSeries() {
            barChart.getData().clear();
        }
    }

}
