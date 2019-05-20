package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.view.broadPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        primaryStage.setTitle("InternationalChess!");
        broadPane pane = new broadPane(60);
        pane.setOnMouseClicked(new Controller(pane));
        primaryStage.setScene(new Scene(pane, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
