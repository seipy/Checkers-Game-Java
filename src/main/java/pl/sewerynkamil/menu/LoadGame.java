package pl.sewerynkamil.menu;

import javafx.scene.control.Alert;
import pl.sewerynkamil.board.Board;

/**
 * Author Kamil Seweryn
 */

public class LoadGame {

    private Board board;

    public LoadGame(Board board) {
        this.board = board;
    }

    public void load() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Load Game");
        alert.setHeaderText(null);
        alert.setContentText("Game Loaded!");

        alert.showAndWait();
    }
}