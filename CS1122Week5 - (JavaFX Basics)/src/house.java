import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import static javafx.scene.paint.Color.*;

public class house extends Application {
    @Override

    public void start (Stage primarystage) {
        BorderPane borderpane = new BorderPane();
        Scene scene = new Scene(borderpane, 800, 600);

        Rectangle rectangle = new Rectangle(800,300);
        rectangle.setFill(GREEN);
        borderpane.setBottom(rectangle);

        Rectangle rectangle2 = new Rectangle(800, 300);
        rectangle2.setFill(LIGHTBLUE);
        borderpane.setTop(rectangle2);

        Rectangle rectangle1 = new Rectangle(80, 100, WHITE);
        borderpane.getChildren().addAll(rectangle1);
        rectangle1.setLayoutX(500);
        rectangle1.setLayoutY(210);

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{525.0, 110.0, 475.0, 210.0, 600.0, 210.0});
        borderpane.getChildren().addAll(triangle);
        triangle.setFill(BROWN);

        Rectangle rectangle3 = new Rectangle(30, 40, CHOCOLATE);
        borderpane.getChildren().addAll(rectangle3);
        rectangle3.setLayoutX(540);
        rectangle3.setLayoutY(270);

        Circle circle = new Circle();
        borderpane.getChildren().addAll(circle);
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(50.0f);
        circle.setFill(YELLOW);

        Rectangle rectangle4 = new Rectangle(10, 60);
        borderpane.getChildren().addAll(rectangle4);
        rectangle4.setFill(BROWN);
        rectangle4.setLayoutX(300);
        rectangle4.setLayoutY(270);

        Polygon triangle2 = new Polygon();
        triangle2.getPoints().addAll(new Double[]{305.0, 125.0, 280.0, 270.0, 330.0, 270.0});
        borderpane.getChildren().addAll(triangle2);
        triangle2.setFill(GREEN);



        primarystage.setTitle("House");
        primarystage.setScene(scene);
        primarystage.show();

    }
}
