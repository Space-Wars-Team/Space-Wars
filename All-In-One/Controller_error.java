package SpaceWars.controllers.Profile;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_error implements Initializable {

    @FXML
    private Button try_again_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try_again_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try_again_button.getScene().getWindow().hide();
            }
        });
    }
}
