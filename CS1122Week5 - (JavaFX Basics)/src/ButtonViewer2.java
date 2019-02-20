import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ButtonViewer2 extends Application {
    public static void main(String[] args) { launch(args); }

@Override
    public void start (Stage stage1) throws Exception {
        final int click [] = {0, 0};


        Button button1 = new Button ("Click me");
        button1.setOnAction(event -> {
                click[0] ++;
                System.out.println("Button1 was clicked " + click [0] + " times");});

        Button button2 = new Button ("Click me");
        button2.setLayoutX(100);
        button2.setOnAction(event -> {
                click[1] ++;
                System.out.println("Button2 was clicked" + click[1] + "times");});

        BorderPane root = new BorderPane();
        root.setTop(button1);
        root.setBottom(button2);

//        root.getChildren().addAll(button1, button2);

        Scene scene1 = new Scene(root, 640, 480);
        stage1.setScene(scene1);
        stage1.setTitle("ButtonViewer2");
        stage1.show();
    }
}
