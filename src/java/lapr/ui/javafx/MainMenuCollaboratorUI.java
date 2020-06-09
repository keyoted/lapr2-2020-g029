package lapr.ui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lapr.ui.javafx.util.FXBridge;
import lapr.ui.javafx.util.HelperUI;

public class MainMenuCollaboratorUI {
    @FXML
    public Button btnUC3NFre;

    @FXML
    public Button btnUC2CTask;

    @FXML
    public void addTransaction(ActionEvent actionEvent) {
        FXBridge.scene = FXBridge.UC.UC1;
        quit();
    }

    @FXML
    public void addFre(ActionEvent actionEvent) {
        FXBridge.scene = FXBridge.UC.UC3;
        quit();
    }

    @FXML
    public void createTask (ActionEvent actionEvent) {
        FXBridge.scene = FXBridge.UC.UC2;
        quit();
    }

    private void quit() {
        ((Stage)btnUC3NFre.getScene().getWindow()).close();
    }
}
