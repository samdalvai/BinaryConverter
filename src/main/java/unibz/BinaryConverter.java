package unibz;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BinaryConverter extends Application {

    public void start(Stage primaryStage) {
        BinaryConverterGUI pane = new BinaryConverterGUI();

        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #f0f0f0");

        Scene scene = new Scene(pane, 500.0D, 350.0D);

        primaryStage.setTitle("Binary Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}