package simpleFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Voting extends Application {

    private int count = 0;
    private Label countLabel;

    @Override
    public void start(Stage primaryStage) {
        // Buttons
        Button ofraBtn = new Button("Ofra Haza");
        Button yardenaBtn = new Button("Yardena Arazi");

        // Top row with buttons
        HBox buttonRow = new HBox(10, ofraBtn, yardenaBtn);
        buttonRow.setPadding(new Insets(10));
        buttonRow.setAlignment(Pos.CENTER);

        // Count label
        countLabel = new Label("0");
        countLabel.setMaxWidth(Double.MAX_VALUE);
        countLabel.setAlignment(Pos.CENTER);
        countLabel.setBackground(new javafx.scene.layout.Background(
            new javafx.scene.layout.BackgroundFill(Color.RED, null, null)
        ));
        countLabel.setPadding(new Insets(8));

        // Bottom row
        HBox countRow = new HBox(countLabel);
        countRow.setPadding(new Insets(0, 10, 10, 10));
        HBox.setHgrow(countLabel, javafx.scene.layout.Priority.ALWAYS);

        // Root layout
        VBox root = new VBox(5, buttonRow, countRow);

        // Button actions — each increments the counter
        ofraBtn.setOnAction(e -> {
            count++;
            countLabel.setText(String.valueOf(count));
        });
        yardenaBtn.setOnAction(e -> {
            count--;
            countLabel.setText(String.valueOf(count));
        });

        Scene scene = new Scene(root, 300, 120);
        primaryStage.setTitle("Voting machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}