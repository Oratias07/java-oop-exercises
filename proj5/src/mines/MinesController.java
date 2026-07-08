package mines;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MinesController {

    @FXML private Label statusLabel;
    @FXML private StackPane gridContainer;

    private MinesFX app;

    void setApp(MinesFX app) {
        this.app = app;
    }

    void setGrid(Node grid) {
        gridContainer.getChildren().setAll(grid);
    }

    void setStatus(String text) {
        statusLabel.setText(text);
    }

    @FXML
    private void onRestart() {
        if (app != null) app.restartGame();
    }
}
