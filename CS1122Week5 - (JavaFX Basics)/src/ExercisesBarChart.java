import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExercisesBarChart extends Application {
    @Override
    public void start (Stage primaryStage)throws Exception {

        BorderPane pane = new BorderPane();

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        final javafx.scene.chart.BarChart<String, Number> barChart = new javafx.scene.chart.BarChart<String, Number>(xAxis, yAxis);
        barChart.setTitle("Bridges");
        yAxis.setLabel("Longest Span (ft)");

        barChart.setBarGap(3);
        barChart.setCategoryGap(2);

        XYChart.Data<String, Integer> dataElement = new XYChart.Data<>("        ",4200);
        XYChart.Data<String, Integer> dataElement1 = new XYChart.Data<>("        ",1595);
        XYChart.Data<String, Integer> dataElement2 = new XYChart.Data<>("        ",2150);
        XYChart.Data<String, Integer> dataElement3 = new XYChart.Data<>("        ",3800);
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series.getData().addAll(dataElement);
        series.setName("Golden Gate");
        series1.setName("Brooklyn");
        series2.setName("Delaware Memorial");
        series3.setName("Mackinac");

        series1.getData().addAll(dataElement1);
        series2.getData().addAll(dataElement2);
        series3.getData().addAll(dataElement3);
        pane.setCenter(barChart);

        barChart.getData().addAll(series, series1, series2, series3);
//        barChart.setBarGap(3);
//        barChart.setCategoryGap(2);

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}