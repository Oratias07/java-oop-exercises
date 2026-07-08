package simpleFX2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VotingController {

    @FXML
    private Label countLabel;

    private int count = 0;

    @FXML
    private void onOfraClicked() {
        count++;
        countLabel.setText(String.valueOf(count));
    }

    @FXML
    private void onYardenaClicked() {
        count--;
        countLabel.setText(String.valueOf(count));
    }
}
