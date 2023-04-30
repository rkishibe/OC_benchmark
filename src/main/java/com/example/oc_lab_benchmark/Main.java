package com.example.oc_lab_benchmark;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import com.example.oc_lab_benchmark.testbench.Testbench;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main extends Application {

    private TextField scoreTextField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Testbench");

        // Create a grid pane for the label, button, and text field
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Create the "Scor" label
        Label scoreLabel = new Label("Scor");
        scoreLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 12));
        GridPane.setConstraints(scoreLabel, 0, 0);
        gridPane.getChildren().add(scoreLabel);

        // Create the "START" button
        Button startButton = new Button("START");
        GridPane.setConstraints(startButton, 1, 0);
        gridPane.getChildren().add(startButton);

        // Create the text field for the score
        scoreTextField = new TextField();
        scoreTextField.setPrefWidth(350);
        scoreTextField.setEditable(false);
        scoreTextField.setAlignment(Pos.CENTER);
        GridPane.setConstraints(scoreTextField, 0, 1, 2, 1);
        gridPane.getChildren().add(scoreTextField);

        // Set the background color
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(255, 204, 255), null, null);
        Background background = new Background(backgroundFill);
        gridPane.setBackground(background);

        // Create a border pane and add the grid pane to the center
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);

        // Set the scene
        Scene scene = new Scene(borderPane, 300, 400);

        // Set the action for the "START" button
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Testbench master = new Testbench();
                long score1 = master.run();
                scoreTextField.setText(Long.toString(score1));
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
