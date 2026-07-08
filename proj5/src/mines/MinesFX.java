package mines;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinesFX extends Application {

    private static final int ROWS  = 9;
    private static final int COLS  = 9;
    private static final int BOMBS = 10;

    private Mines mines;
    private Button[][] buttons;
    private boolean gameOver;
    private boolean won;
    private MinesController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mines.fxml"));
        BorderPane root = loader.load();
        controller = loader.getController();
        controller.setApp(this);

        newGame();

        stage.setScene(new Scene(root));
        stage.setTitle("Minesweeper");
        stage.show();
    }

    void restartGame() {
        newGame();
    }

    private void newGame() {
        mines = new Mines(ROWS, COLS, BOMBS);
        gameOver = false;
        won = false;
        buildGrid();
        controller.setStatus("Click a cell to start");
    }

    private void buildGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);
        buttons = new Button[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                Button btn = new Button();
                btn.setPrefSize(40, 40);
                btn.setFocusTraversable(false);
                int row = r, col = c;
                btn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> handleClick(row, col, e));
                buttons[r][c] = btn;
                grid.add(btn, c, r);
            }
        }

        controller.setGrid(grid);
        updateBoard();
    }

    private void handleClick(int row, int col, MouseEvent e) {
        if (gameOver) return;

        if (e.getButton() == MouseButton.SECONDARY) {
            mines.toggleFlag(row, col);
        } else {
            boolean safe = mines.open(row, col);
            if (!safe) {
                gameOver = true;
                won = false;
                mines.setShowAll(true);
            } else if (mines.isDone()) {
                gameOver = true;
                won = true;
            }
        }
        updateBoard();
    }

    private void updateBoard() {
        if (gameOver && won) {
            controller.setStatus("You won! Congratulations");
        } else if (gameOver) {
            controller.setStatus("Game Over");
        } else {
            controller.setStatus("Click a cell");
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                applyCell(buttons[r][c], mines.get(r, c));
            }
        }
    }

    private void applyCell(Button btn, String val) {
        switch (val) {
            case ".":
                btn.setText("");
                btn.setStyle("-fx-background-color: lightgray;");
                btn.setDisable(gameOver);
                break;
            case "F":
                btn.setText("F");
                btn.setStyle("-fx-background-color: gold; -fx-font-weight: bold; -fx-text-fill: darkred;");
                btn.setDisable(gameOver);
                break;
            case "X":
                btn.setText("💣");
                btn.setStyle("-fx-background-color: salmon;");
                btn.setDisable(true);
                break;
            case " ":
                btn.setText("");
                btn.setStyle("-fx-background-color: white;");
                btn.setDisable(true);
                break;
            default:
                btn.setText(val);
                btn.setStyle("-fx-background-color: white; -fx-font-weight: bold; -fx-text-fill: " + numberColor(val) + ";");
                btn.setDisable(true);
                break;
        }
    }

    private String numberColor(String val) {
        switch (val) {
            case "1": return "blue";
            case "2": return "green";
            case "3": return "red";
            case "4": return "darkblue";
            case "5": return "darkred";
            case "6": return "teal";
            case "7": return "black";
            case "8": return "gray";
            default:  return "black";
        }
    }
}
