import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author SiddheshDM
 *
 * A BarChart requires two axis as input to its constructor
 * CategoryAxis xAxis = new CategoryAxis ();
 * NumberAxis yAxis = new NumberAxis ();
 *
 * BarChart options
 * You can set the title, axis labels, and display tick marks
 *
 * barchart.setTitle ("abnaocn")
 *
 */

public class BarChart123 extends Application {
    @Override
    public void start (Stage primaryStage)throws Exception {

        BorderPane borderpane = new BorderPane();
        HBox hBox = new HBox();

        Label nameLabel = new Label("Name: ");
        TextField nameField = new TextField();

        Label valueLabel = new Label("Value: ");
        TextField valueField = new TextField();

        Button addButton = new Button("Add");

        hBox.getChildren().addAll (nameLabel, nameField, valueLabel, valueField, addButton);



        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        final javafx.scene.chart.BarChart<String, Number> barChart = new javafx.scene.chart.BarChart<String, Number>(xAxis, yAxis);
        barChart.setTitle ("Bar Chart Title");
        xAxis.setLabel("Category");
        yAxis.setLabel("Double");
        ArrayList<String> abc = new ArrayList<>();
        borderpane.setTop(hBox);
        borderpane.setCenter(barChart);



        addButton.setOnAction(event -> {
            Series series1 = new Series ();
            barChart.getData().add(series1);
            String name = nameField.getText();
            series1.setName(name);
            abc.add(name);
            Double value = Double.valueOf(valueField.getText());
            XYChart.Data<String, Double> dataElement = new XYChart.Data<>(name,value);
            series1.getData().add(dataElement);
            xAxis.gapStartAndEndProperty().setValue(true);


        });

//        Data<String, Double> dataElement = new Data<>("PI",3.1415926);
//        Data<String, Double> dataElement1 = new Data<>("Twelve",12.0);
//        Data<String, Double> dataElement2 = new Data<>("Two",2.0);
//        Data<String, Double> dataElement3 = new Data<>("Seven",7.0);
//        Data<String, Double> dataElement4 = new Data<>("Ten",10.0);
//        Series series = new Series();
//        series.getData().addAll(dataElement, dataElement1, dataElement2,dataElement3, dataElement4);
//        series.setName ("Legend Label");
//
//        Data<String, Double> dataElement5 = new Data<>("Life",12.2);
//        Data<String, Double> dataElement6 = new Data<>("Cookie",27.1);
//        Data<String, Double> dataElement7 = new Data<>("Jack",11.0);
//        Data<String, Double> dataElement8 = new Data<>("Donut",8.3);
//        Data<String, Double> dataElement9 = new Data<>("Nine",9.0);
//        Series series2 = new Series();
//        series2.getData().addAll(dataElement5, dataElement6, dataElement7,dataElement8, dataElement9);
//        series2.setName ("Another Label");

//        barChart.getData().addAll(series, series2);

        Scene scene = new Scene(borderpane, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
