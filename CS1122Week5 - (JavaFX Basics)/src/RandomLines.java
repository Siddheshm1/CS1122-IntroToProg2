import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;




public class RandomLines extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);



        for(int i = 0; i < 75; i++){

            double R =  (Math.random());
            double G =  (Math.random());
            double B =  (Math.random());

            int startingX = (int) (Math.random() * scene.getWidth());
            int endingX = (int) (Math.random() * scene.getWidth());
            int startingY = (int) (Math.random() * scene.getHeight());
            int endingY = (int) (Math.random() * scene.getHeight());

            Line line1 = new Line(startingX,startingY,endingX,endingY);
            line1.setStroke(Color.color(R,G,B));
            line1.setStrokeWidth((Math.random()*10+1));
            root.getChildren().add(line1);
        }

        primaryStage.setScene(scene);
        primaryStage.setTitle("My JavaFX Window");
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
}

